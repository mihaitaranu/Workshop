package ro.teamnet.zth.app;


import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.controller.DepartmentController;
import ro.teamnet.zth.app.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by Taranu on 06/05/15.
 */
public class MyDispatcherServlet extends HttpServlet {
    HashMap<String, MethodAttributes> allowedMethods = new HashMap<>();

    @Override
    public void init() throws ServletException {
        try {
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.app.controller");
            allowedMethods = getAllowedRequestMethods(classes);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    private HashMap<String, MethodAttributes> getAllowedRequestMethods(Iterable<Class> classes) {
        for (Class controller : classes) {
            if (controller.isAnnotationPresent(MyController.class)) {
                MyController annotation = (MyController) controller.getAnnotation(MyController.class);
                String controllerUrlPath = annotation.urlPath();
                Method[] methods = controller.getMethods();
                for (Method controllerMethod : methods) {
                    if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                        MyRequestMethod controllerMethodAnnotation = controllerMethod.getAnnotation(MyRequestMethod.class);
                        String key = controllerUrlPath + controllerMethodAnnotation.urlPath();
                        MethodAttributes methodAttributes = new MethodAttributes();
                        methodAttributes.setControllerClass(controller.getName());
                        methodAttributes.setMethodName(controllerMethod.getName());
                        methodAttributes.setMethodType(controllerMethodAnnotation.methodType());
                        methodAttributes.setParameters(controllerMethod.getParameterTypes());
                        allowedMethods.put(key, methodAttributes);
                    }
                }
            }
        }
        return allowedMethods;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReplay(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReplay(req, resp);
    }

    private void dispatchReplay(HttpServletRequest req, HttpServletResponse resp) {

        Object r = null;
        try {
            r = dispatch(req, resp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            replay(r, req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String pathinfo = req.getPathInfo();
        if (allowedMethods.containsKey(pathinfo)) {
            String controllerClassString = allowedMethods.get(pathinfo).getControllerClass();
            Class controllerClass = Class.forName(controllerClassString);
            Object controller = controllerClass.newInstance();
            String methodName = allowedMethods.get(pathinfo).getMethodName();
            Method method = controller.getClass().getMethod(methodName, allowedMethods.get(pathinfo).getParameters());
            Object r;
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            if (parameterAnnotations.length != 0) {
                List<String> methodParamValues = new ArrayList<>();
                for (int i = 0; i < parameterAnnotations.length; i++) {
                    MyRequestParam annotation = (MyRequestParam) parameterAnnotations[i][0];
                    String valOfParamName = req.getParameter(annotation.paramName());
                    methodParamValues.add(valOfParamName);
                }
                    r = method.invoke(controller, (String[]) methodParamValues.toArray(new String[parameterAnnotations.length]));
                }else{
                    r = method.invoke(controller);
                }
                return r;
            }


//        if (pathinfo.startsWith("/employees")) {
//            EmployeeController employeeController = new EmployeeController();
//            String allEmployees = employeeController.getAllEmployees();
//            return allEmployees;
//        } else if (pathinfo.startsWith("/departments")) {
//            DepartmentController dc = new DepartmentController();
//            String allDeprtments = dc.getAllDeprtments();
//            return allDeprtments;
//        }
            return "Hello!";
        }

    private void replay(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        PrintWriter pr = resp.getWriter();
        pr.printf(mapper.writeValueAsString(r));

    }
}

package ro.teamnet.zth.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by Vlad.Bulimac on 5/5/2015.
 */
public class HttpSessionZTH extends HttpServlet {

    //Default username and password
    private final String defaultUser = "admin";
    private final String defaultPass = "pass";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        String response = null;
        username = req.getParameter("username");
        password = req.getParameter("password");

        Cookie[] cookies = req.getCookies();
        //TODO de completat cu cerintele din workshop
        if (username.equals(defaultUser) && password.equals(defaultPass)) {
            response = "Wellcome back! \n";
            response += "Username:" + username +"\n";

            for (int i = 0; i < cookies.length; i++) {
                response += cookies[i].getName()+":";
                response +=cookies[i].getValue() +"\n";
            }
            response += req.getRequestedSessionId();
            resp.getWriter().write(response);
        }
        else {
            req.getSession().setAttribute("user",username);
            req.getSession().setAttribute("session",req.getSession());
            resp.sendRedirect("loginFail.jsp");}
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

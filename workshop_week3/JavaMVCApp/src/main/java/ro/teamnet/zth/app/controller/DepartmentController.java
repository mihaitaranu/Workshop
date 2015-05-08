package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 06/05/15.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(methodType = "GET", urlPath = "/all")
    public List<Department> getAllDeprtments(){
        return new DepartmentServiceImpl().findAllDepartments();
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/one")
    public Department getOneDepartment(@MyRequestParam(paramName = "idDepartment")String id){
        return new DepartmentServiceImpl().findOneDepartment(Integer.parseInt(id));
    }
}

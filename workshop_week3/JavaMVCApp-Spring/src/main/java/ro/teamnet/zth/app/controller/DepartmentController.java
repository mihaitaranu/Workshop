package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 06/05/15.
 */
public class DepartmentController {
    public List<Department> getAllDeprtments(){
        return new DepartmentServiceImpl().findAllDepartments();
    }
    public Department getOneDepartment(String id){
        return new DepartmentServiceImpl().findOneDepartment(Integer.parseInt(id));
    }
}

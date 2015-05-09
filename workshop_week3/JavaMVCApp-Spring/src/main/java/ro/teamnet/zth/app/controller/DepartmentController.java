package ro.teamnet.zth.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 06/05/15.
 */
@Controller()
@RequestMapping(value = "/departments")
public class DepartmentController {
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Department> getAllDeprtments() {
        return new DepartmentServiceImpl().findAllDepartments();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{departmentId}")
    public
    @ResponseBody
    Department getOneDepartment(@PathVariable(value = "departmentId") String id) {
        return new DepartmentServiceImpl().findOneDepartment(Integer.parseInt(id));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/{departmentId}")
    public @ResponseBody String deleteDepartment(@PathVariable(value = "departmentId")String id){
        new DepartmentServiceImpl().deleteDepartment(Integer.parseInt(id));
        return "Departamanetul a fost sters cu succes.";
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Department saveDepartment(@RequestBody Department department){
        return new DepartmentDao().insertDepartment(department);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Department updateDepartment(@RequestBody Department department){
        return new DepartmentDao().updateDepartment(department);
    }
}

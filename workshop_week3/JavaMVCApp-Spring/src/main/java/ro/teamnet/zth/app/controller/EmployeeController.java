package ro.teamnet.zth.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 06/05/15.
 */
@Controller()
@RequestMapping(value = "/employees")
public
@ResponseBody
class EmployeeController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return new EmployeeServiceImpl().findAllEmployees();
    }

    @RequestMapping(value = "/{idEmployee}", method = RequestMethod.GET)
    public
    @ResponseBody

    Employee getOneEmployee(@PathVariable(value ="idEmployee" ) String idEmployee) throws IllegalAccessException, InstantiationException {
        return new EmployeeServiceImpl().findOneEmployee(Integer.parseInt(idEmployee));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/{idEmployee}")
    public  @ResponseBody String deleteOneEmployee(@PathVariable(value ="idEmployee" )String idEmployee) {
        new EmployeeServiceImpl().deleteEmployee(Integer.parseInt(idEmployee));
        return "Userul a fost strs";
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Employee saveEmployee(@RequestBody Employee employee){
        new EmployeeServiceImpl().addEmployee(employee);
        return employee;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employee){
        new EmployeeServiceImpl().updateEmployee(employee);
        return employee;
    }
}

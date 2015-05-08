package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Taranu on 06/05/15.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {

    @MyRequestMethod(methodType ="GET" , urlPath = "/all")
    public List<Employee> getAllEmployees(){
        return new EmployeeServiceImpl().findAllEmployees();
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/one")
    public Employee getOneEmployee(@MyRequestParam(paramName = "idEmployee")String idEmployee) throws IllegalAccessException, InstantiationException {
        return new EmployeeServiceImpl().findOneEmployee(Integer.parseInt(idEmployee));
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/delete")
    public void deleteOneEmployee(@MyRequestParam(paramName = "idEmployee")String idEmployee){
        new EmployeeServiceImpl().deleteEmployee(Integer.parseInt(idEmployee));
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/save")
    public Employee saveEmployee(
            @MyRequestParam(paramName = "firstName")String firstName,
            @MyRequestParam(paramName = "lastName")String lastName,
            @MyRequestParam(paramName = "email")String email,
            @MyRequestParam(paramName = "phoneNumber")String phoneNumber,
            @MyRequestParam(paramName = "hireDate")String hireDate,
            @MyRequestParam(paramName = "jobId")String jobId,
            @MyRequestParam(paramName = "salary")String salary,
            @MyRequestParam(paramName = "commissionPct")String commissionPct,
            @MyRequestParam(paramName = "managerId")String managerId,
            @MyRequestParam(paramName = "departmentId")String departmentId
    ){

        Employee employee=new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setHireDate(java.sql.Date.valueOf(hireDate));
        employee.setJobId(jobId);
        employee.setSalary( new BigDecimal(salary));
        employee.setCommissionPct(new BigDecimal(commissionPct));
        employee.setManagerId(Integer.parseInt(managerId));
        employee.setDepartmentId(Integer.parseInt(departmentId));
        return new EmployeeServiceImpl().addEmployee(employee);

    }
}

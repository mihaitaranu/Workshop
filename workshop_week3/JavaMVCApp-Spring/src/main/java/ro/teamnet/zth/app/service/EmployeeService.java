package ro.teamnet.zth.app.service;


import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public interface EmployeeService {
    public List<Employee> findAllEmployees();
    public Employee findOneEmployee(Integer id);
    public void deleteEmployee(Integer id);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
}

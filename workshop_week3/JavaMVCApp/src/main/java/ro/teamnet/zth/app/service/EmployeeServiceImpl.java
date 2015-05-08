package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findAllEmployees() {

        return new EmployeeDao().getAllEmployees();
    }

    public Employee findOneEmployee(Integer id) {
        return new EmployeeDao().getEmployeeById(id);
    }
    public void deleteEmployee(Integer id){
        new EmployeeDao().deleteEmployee(new EmployeeDao().getEmployeeById(id));
    }
    public Employee addEmployee(Employee employee){
        return new EmployeeDao().insertEmployee(employee);
    }
}

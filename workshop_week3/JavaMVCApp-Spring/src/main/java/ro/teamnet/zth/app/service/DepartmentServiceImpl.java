package ro.teamnet.zth.app.service;

import org.springframework.web.bind.annotation.ResponseBody;
import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<Department> findAllDepartments() {
       return new DepartmentDao().getAllDepartments();
    }

    @Override
    public Department findOneDepartment(Integer id) {
        return new DepartmentDao().getDepartmentById(id);
    }

    @Override
    public void deleteDepartment(Integer id) {
        List<Employee> employees= new EmployeeDao().getEmployeesByDepartmentID(id);
        for(Employee employee:employees){
            employee.setDepartmentId(null);
            new EmployeeDao().updateEmployee(employee);
        }
        new DepartmentDao().deleteDepartment(new DepartmentDao().getDepartmentById(id));
    }

    @Override
    public Department updateDepartment(Department department) {
       return new DepartmentDao().updateDepartment(department);
    }

    @Override
    public Department addDepartment(Department department) {
        return new DepartmentDao().insertDepartment(department);
    }
}

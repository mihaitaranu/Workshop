package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.domain.Department;

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
}

package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Department;


import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public interface DepartmentService {
    public List<Department> findAllDepartments();
    public Department findOneDepartment(Integer id);
}

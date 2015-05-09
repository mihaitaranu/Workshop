package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.dao.JobDao;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.domain.Job;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class JobServiceImpl implements JobService {

    @Override
    public List<Job> findAllJobs() {
        return new JobDao().getAllJobs();
    }

    @Override
    public Job findOneJob(Integer id) {
        return new JobDao().getJobById(id);
    }

    @Override
    public void deleteJob(Integer id) {
        List<Employee> employees= new EmployeeDao().getEmployeesByJobID(id);
        for(Employee employee:employees){
            employee.setJobId(5);
            new EmployeeDao().updateEmployee(employee);
        }
         new JobDao().deleteJob(new JobDao().getJobById(id));
    }

    @Override
    public Job saveJob(Job job) {
        return new JobDao().insertJob(job);
    }

    @Override
    public Job updateJob(Job job) {
        return new JobDao().updateJob(job);
    }


}

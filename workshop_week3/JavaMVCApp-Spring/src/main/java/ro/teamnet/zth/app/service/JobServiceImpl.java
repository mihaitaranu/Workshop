package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.JobDao;
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


//
//    @Override
//    public Job findOneJob(String id) {
//        return new JobDao().getJobById(id);
//    }
//
//
}

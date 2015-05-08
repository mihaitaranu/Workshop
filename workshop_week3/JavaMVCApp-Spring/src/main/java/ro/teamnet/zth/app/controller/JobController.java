package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class JobController {

    public List<Job> getAllJobs(){
        return new JobServiceImpl().findAllJobs();
    }
    public Job getOneJob( String id){
//        return new JobServiceImpl().findOneJob(id);
    return null;
    }
}
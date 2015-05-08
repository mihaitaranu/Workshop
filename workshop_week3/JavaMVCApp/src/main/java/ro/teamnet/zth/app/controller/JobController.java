package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
@MyController(urlPath = "/jobs")
public class JobController {

    @MyRequestMethod(methodType ="GET" , urlPath = "/all")
    public List<Job> getAllJobs(){
        return new JobServiceImpl().findAllJobs();
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/one")
    public Job getOneJob(@MyRequestParam(paramName = "idJob") String id){
//        return new JobServiceImpl().findOneJob(id);
    return null;
    }
}
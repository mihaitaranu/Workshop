package ro.teamnet.zth.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
@Controller
@RequestMapping(value = "/jobs")
public
@ResponseBody
class JobController {
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Job> getAllJobs() {
        return new JobServiceImpl().findAllJobs();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{jobId}")
    public
    @ResponseBody
    Job getOneJob(@PathVariable(value = "jobId") String id) {
        return new JobServiceImpl().findOneJob(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{jobID}")
    public
    @ResponseBody
    String delteJob(@PathVariable(value = "jobID") String id) {
        new JobServiceImpl().deleteJob(Integer.parseInt(id));
        return "Jobul a fost sters.";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Job saveJob(@RequestBody Job job) {
        return new JobServiceImpl().saveJob(job);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    Job updateJob(@RequestBody Job job){
        return new JobServiceImpl().updateJob(job);
    }
}
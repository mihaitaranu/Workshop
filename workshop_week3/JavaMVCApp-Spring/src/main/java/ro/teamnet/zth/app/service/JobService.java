package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Job;

import java.util.List;


/**
 * Created by Taranu on 07/05/15.
 */
public interface JobService {
    public List<Job> findAllJobs();

    public Job findOneJob(Integer id);

    public void deleteJob(Integer id);

    public Job saveJob(Job job);

    public Job updateJob(Job job);
}

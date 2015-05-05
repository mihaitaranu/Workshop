package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Taranu on 05/05/15.
 */
@Table(name = "jobs")
public class Job {

    @Id(name="job_id")
    private String id;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name="min_salary")
    private Integer minSalary;

    @Column(name="max_salary")
    private Integer maxSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job jobs = (Job) o;

        if (id != null ? !id.equals(jobs.id) : jobs.id != null) return false;
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null) return false;
        if (minSalary != null ? !minSalary.equals(jobs.minSalary) : jobs.minSalary != null) return false;
        return !(maxSalary != null ? !maxSalary.equals(jobs.maxSalary) : jobs.maxSalary != null);

    }

}

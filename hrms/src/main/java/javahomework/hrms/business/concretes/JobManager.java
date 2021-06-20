package javahomework.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.JobService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.ErrorResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.dataAccess.abstracts.JobDao;
import javahomework.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Jobs are listed.");
	}

	@Override
	public Result add(Job job) {
		if (this.jobPositionExist(job.getJobTitle()).getData() != null) {
			return new ErrorResult("Job Title exist.");
		}
		this.jobDao.save(job);
		return new SuccessResult("Job added.");
	}

	private DataResult<Job> jobPositionExist(String jobName) {
		return new SuccessDataResult<Job>(this.jobDao.findByName(jobName));
	}

}

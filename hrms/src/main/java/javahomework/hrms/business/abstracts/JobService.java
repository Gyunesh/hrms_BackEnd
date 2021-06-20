package javahomework.hrms.business.abstracts;

import java.util.List;


import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Job;

public interface JobService {

	DataResult<List<Job>> getAll();
	
	Result add(Job job);
}

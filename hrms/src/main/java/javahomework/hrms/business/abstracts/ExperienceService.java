package javahomework.hrms.business.abstracts;

import java.util.List;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience exp);

	DataResult<List<Experience>> getByJobSeekerOrderByLeaveDateDesc(int jobSeekerId);

	DataResult<List<Experience>> getAll();
	
	DataResult<List<Experience>> getByJobSeekerId(int JobSeekerId);
}

package javahomework.hrms.business.abstracts;

import java.util.List;


import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.JobSeeker;
import javahomework.hrms.entities.dto.CvDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	
	Result add(JobSeeker jobSeeker);
	
	DataResult<JobSeeker> get(int id);
	
	DataResult<CvDto> getCv(int jobSeekerId);
}

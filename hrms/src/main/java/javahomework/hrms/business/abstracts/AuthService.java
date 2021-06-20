package javahomework.hrms.business.abstracts;

import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.entities.concretes.Employer;
import javahomework.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	DataResult<JobSeeker> registerJobSeeker(JobSeeker jobSeeker, String confirmPassword);

	DataResult<Employer> registerEmployer(Employer employer, String confirmPassword);
}

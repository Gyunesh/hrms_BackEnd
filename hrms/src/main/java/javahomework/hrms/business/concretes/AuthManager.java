package javahomework.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javahomework.hrms.business.abstracts.AuthService;
import javahomework.hrms.business.abstracts.EmployerService;
import javahomework.hrms.business.abstracts.JobSeekerService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.ErrorDataResult;
import javahomework.hrms.core.utilities.results.ErrorResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.core.utilities.results.SuccessDataResult;
import javahomework.hrms.core.utilities.results.SuccessResult;
import javahomework.hrms.entities.concretes.Employer;
import javahomework.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService jobSeekerService;
	private EmployerService employerService;

	@Autowired
	public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
	}

	@Override
	public DataResult<JobSeeker> registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
		if (this.confirmPass(jobSeeker.getPassword(), confirmPassword).isSuccess()) {
			this.jobSeekerService.add(jobSeeker);
			return new SuccessDataResult<JobSeeker>();
		}
		return new ErrorDataResult<JobSeeker>("Register failed.");
	}

	@Override
	public DataResult<Employer> registerEmployer(Employer employer, String confirmPassword) {
		if (this.confirmPass(employer.getPassword(), confirmPassword).isSuccess()) {
			if (this.checkEmailDomain(employer.getEmail(), employer.getWebSite()).isSuccess()) {
				this.employerService.add(employer);
				return new SuccessDataResult<Employer>("Employer added.");
			}
			return new ErrorDataResult<Employer>(employer, "Domain not match.");
		}
		return new ErrorDataResult<Employer>("Register failed.");
	}

	private Result confirmPass(String password, String confirmPassword) {

		if (password.equals(confirmPassword)) {

			return new SuccessResult("Password Match!");
		}
		return new ErrorResult("Password not match!");

	}

	private Result checkEmailDomain(String email, String website) {

		String[] mail = email.split("@", 2);
		String web = website.substring(4);
		if (mail[1].equals(web)) {
			return new SuccessResult("Domain Match");
		}
		return new ErrorResult("Domain not match");
	}

}

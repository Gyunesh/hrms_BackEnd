package javahomework.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.AuthService;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.Employer;
import javahomework.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auths")
@CrossOrigin
public class AuthsController {

	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/registerEmployer")
	public Result add(@RequestBody Employer employer, String confirmPass) {
		return this.authService.registerEmployer(employer, confirmPass);
	}

	@PostMapping("/registerJobSeeker")
	public Result add(@RequestBody JobSeeker jobSeeker, String confirmPass) {
		return this.authService.registerJobSeeker(jobSeeker, confirmPass);
	}

}

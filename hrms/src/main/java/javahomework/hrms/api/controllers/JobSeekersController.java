package javahomework.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.JobSeekerService;
import javahomework.hrms.core.utilities.results.DataResult;

import javahomework.hrms.entities.concretes.JobSeeker;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}

	@GetMapping("/cv")
	public ResponseEntity<?> getCv(@RequestParam int jobSeekerId) {
		return ResponseEntity.ok(this.jobSeekerService.getCv(jobSeekerId));
	}

}

package javahomework.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.JobAdvertService;
import javahomework.hrms.core.utilities.results.DataResult;
import javahomework.hrms.core.utilities.results.Result;
import javahomework.hrms.entities.concretes.JobAdvert;
import javahomework.hrms.entities.dto.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}

	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		return this.jobAdvertService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}

	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(@RequestParam int id) {
		return this.jobAdvertService.changeOpenToClose(id);
	}

	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}

	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt() {
		return this.jobAdvertService.findAllByOrderByPublishedAt();
	}

	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(@RequestParam int id) {
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}

	@GetMapping("/getallbydate")
	public DataResult<List<JobAdvert>> getAllByDate() {
		return this.jobAdvertService.getAllSortedByDate();
	}

	@GetMapping("/getallbyactive")
	public DataResult<List<JobAdvert>> getByIsActive() {
		return this.jobAdvertService.getByIsActive();
	}

	@GetMapping("/getalldetail")
	public DataResult<List<JobAdvertDto>> getAllDetail() {
		return this.jobAdvertService.getAllDetail();
	}
}

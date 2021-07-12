package javahomework.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import javahomework.hrms.business.abstracts.ExperienceService;
import javahomework.hrms.core.utilities.results.ErrorDataResult;
import javahomework.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService=experienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience) {
		return ResponseEntity.ok(this.experienceService.add(experience));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {

		return ResponseEntity.ok(this.experienceService.getAll());
	}

	@GetMapping("/getbyjobseeker")
	public ResponseEntity<?> getByJobSeekerId(int jobseekerId) {
		return ResponseEntity.ok(this.experienceService.getByJobSeekerId(jobseekerId));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");

		return errors;

	}

}

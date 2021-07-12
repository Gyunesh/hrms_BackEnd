package javahomework.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import javahomework.hrms.business.abstracts.ProgrammingSkillService;
import javahomework.hrms.core.utilities.results.ErrorDataResult;

import javahomework.hrms.entities.concretes.ProgrammingSkill;

@RestController
@RequestMapping("/api/programmingskills")
@CrossOrigin
public class PromrammingSkillsController {
	private ProgrammingSkillService programmingSkillService;

	@Autowired
	public PromrammingSkillsController(ProgrammingSkillService programmingSkillService) {

		super();
		this.programmingSkillService = programmingSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ProgrammingSkill programmingSkill) {
		return ResponseEntity.ok(this.programmingSkillService.add(programmingSkill));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {

		return ResponseEntity.ok(this.programmingSkillService.getAll());
	}

	@GetMapping("/getbyjobseeker")
	public ResponseEntity<?> getByJobSeekerId(int jobseekerId) {
		return ResponseEntity.ok(this.programmingSkillService.getByJobSeekerId(jobseekerId));
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

package javahomework.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.ForeignLanguageService;
import javahomework.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguages")
@CrossOrigin
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ForeignLanguage foreignLanguage) {
		return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
	}

	@GetMapping("/add")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.foreignLanguageService.getAll());
	}

}

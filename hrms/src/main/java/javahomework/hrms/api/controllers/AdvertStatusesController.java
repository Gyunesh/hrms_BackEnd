package javahomework.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.AdvertStatusService;

@RestController
@RequestMapping("api/statuses")
@CrossOrigin
public class AdvertStatusesController {

	private AdvertStatusService advertStatusService;

	@Autowired
	public AdvertStatusesController(AdvertStatusService advertStatusService) {
		super();
		this.advertStatusService = advertStatusService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.advertStatusService.getAll());
	}

}

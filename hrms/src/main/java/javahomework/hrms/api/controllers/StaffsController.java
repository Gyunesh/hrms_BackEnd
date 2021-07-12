package javahomework.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javahomework.hrms.business.abstracts.StaffService;
import javahomework.hrms.entities.concretes.AdvertStatus;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class StaffsController {
	
	private StaffService staffService;
	
	@Autowired
	public StaffsController(StaffService staffService) {
		super();
		this.staffService=staffService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		return ResponseEntity.ok(this.staffService.getAll());
	}
	
	@PostMapping("/confirm")
	public ResponseEntity<?> confirm(@RequestBody AdvertStatus advertStatus){
		return ResponseEntity.ok(this.staffService.confirm(advertStatus));
	}

}

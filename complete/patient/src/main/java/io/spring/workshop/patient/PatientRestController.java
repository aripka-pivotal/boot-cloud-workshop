package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {
	@Autowired
	private PatientRepo patientRepo;
	
	@RequestMapping("/patients")
	public Iterable<Patient> allPatients(){
		return patientRepo.findAll();
	}
}

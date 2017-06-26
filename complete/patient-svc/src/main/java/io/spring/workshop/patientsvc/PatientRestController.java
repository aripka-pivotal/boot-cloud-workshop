package io.spring.workshop.patientsvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {
	@Autowired
	private PatientRepo patientRepo;
	
	@Value("${server.port}")
	private int serverPort;
	
	@RequestMapping("/patients")
	public Iterable<Patient> allPatients(){
		
		//this is janky code to demonstrate differnt behavior for different servers
		if(serverPort%2==0){
			ArrayList<Patient> patients = new ArrayList<>();
			
			for(Patient patient: patientRepo.findAll()){
				Patient p = new Patient();
				patients.add(p);
				p.setId(patient.getId());
				p.setName(patient.getName().toUpperCase());
			}
			
			return patients;
		}
		
		return patientRepo.findAll();
	}
}

package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {
	@Autowired
	private PatientRepo patientRepo;
	
	@RequestMapping("/viewPatients")
	public String allPatients(Model model){
		model.addAttribute("patients", patientRepo.findAll());
		return "patients";
	}
}
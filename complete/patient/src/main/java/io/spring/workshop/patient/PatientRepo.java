package io.spring.workshop.patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Long> {

}

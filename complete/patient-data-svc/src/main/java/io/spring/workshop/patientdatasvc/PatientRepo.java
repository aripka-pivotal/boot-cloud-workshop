package io.spring.workshop.patientdatasvc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="patient", collectionResourceRel="patientCollection")
public interface PatientRepo extends CrudRepository<Patient, Long> {
	
	public Iterable<Patient> findByName(@Param("name") String name);
	
	public Iterable<Patient> findByNameStartsWith(@Param("name") String name);

}

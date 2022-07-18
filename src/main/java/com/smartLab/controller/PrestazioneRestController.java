/*
 * 
 * @see Prestazione.java
 * @see PrestazioneService.java
 * @see PrestazioneServiceImpl.java
 * @see PrestazioneRepository.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */

package com.smartLab.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartLab.service.CRUDService;
import com.smartLab.service.PrestazioneService;
import com.smartLab.model.Prestazione;

/*
 * Medical service RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/prestazioni")
public class PrestazioneRestController {
	private static final Logger logger = LoggerFactory.getLogger(PrestazioneRestController.class);

	@Autowired
	private CRUDService<Prestazione> crud_service;

	@Autowired
	private PrestazioneService<Prestazione> medicalservice_service;

	/*
	 * This method select all the category in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Prestazione> listAllMedicalService() {
		List<Prestazione> all_medicalservices = crud_service.getAll();
		logger.info("------------------ Fetching medical services list from database ------------------");
		logger.info("Record list size:  " + all_medicalservices.size());

		return all_medicalservices;
	}

	/*
	 * This method select a category in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Prestazione getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single medical service element by id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new category in the database
	 * 
	 * @param category the category object to save
	 */
	@PostMapping
	public Prestazione createMedicalService(@RequestBody Prestazione medical_service) {
		logger.info("------------------ Create a medical service ------------------");
		return crud_service.create(medical_service);
	}

	/*
	 * This method update a service in the database
	 * 
	 * @param medical_service the service object data to update
	 * 
	 * @param id the id of the service to update
	 */
	@PutMapping
	public Prestazione updateCategory(@RequestBody Prestazione medical_service, int id) {
		logger.info("------------------ Update a service ------------------");
		return crud_service.update(medical_service, id);
	}

	/*
	 * This method delete a service from database
	 * 
	 * @param id the id of the service you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single service element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single service element by service name
	 * 
	 * @param service the service name to find in the database
	 * 
	 */
	@GetMapping(value = "/service/{name}", produces = "application/json")
	public Prestazione selectByName(@PathVariable("name") String name) {

		logger.info("------------------ Fetched a service from name ------------------");
		return medicalservice_service.selectByNome(name);
	}

}

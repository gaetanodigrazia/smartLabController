/*
 * 
 * @see Cittadino.java
 * @see CittadinoService.java
 * @see CittadinoServiceImpl.java
 * @see CittadinoRepository.java
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartLab.service.CRUDService;
import com.smartLab.service.CittadinoService;
import com.smartLab.model.Cittadino;

/*
 * Citizen RESTful controller class
 * 
 * */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cittadini")
public class CittadinoRestController {
	private static final Logger logger = LoggerFactory.getLogger(CittadinoRestController.class);

	@Autowired
	private CittadinoService<Cittadino> citizen_service;

	@Autowired
	private CRUDService<Cittadino> crud_service;

	/*
	 * This method select all the citizen in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Cittadino> listAllBookings() {
		List<Cittadino> all_citizen = crud_service.getAll();
		logger.info("------------------ Fetching citizens list from database ------------------");
		logger.info("Record list size:  " + all_citizen.size());
		return crud_service.getAll();
	}

	/*
	 * This method select a citizen in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Cittadino getById(@PathVariable(name = "id") int id) {
		logger.info("------------------ Fetching a single citizen element from id ------------------");

		return crud_service.read(id);
	}

	/*
	 * This method store a new citizen in the database
	 * 
	 * @param citizen the citizen object to save
	 */
	@PostMapping
	public Cittadino createCitizen(@RequestBody Cittadino citizen) {
		logger.info("------------------ Create a citizen ------------------");
		return crud_service.create(citizen);
	}

	/*
	 * This method update a new citizen in the database
	 * 
	 * @param citizen the citizen object data to update
	 * 
	 * @param id the id of the citizen to update
	 */
	@PutMapping
	public Cittadino updateCitizen(@RequestBody Cittadino citizen, int id) {
		logger.info("------------------ Update a citizen ------------------");
		return crud_service.update(citizen, id);
	}

	/*
	 * This method delete a citizen from database
	 * 
	 * @param id the id of the citizen you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single citizen element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a citizen in the database by email
	 * 
	 * @param email the email to search in the database
	 */
	@GetMapping(value = "/search/email", produces = "application/json")
	public Cittadino getByEmail(@RequestParam(name = "email") String email) {

		logger.info("------------------ Fetched a single citizen element from email ------------------");
		return citizen_service.selectByEmail(email);
	}

	/*
	 * This method select a citizen in the database by firstname and lastname
	 * 
	 * @firstname email the firstname to search in the database
	 * 
	 * @lastname email the lastname to search in the database
	 * 
	 * Sample call:
	 * http://localhost:8050/cittadino/search?firstname=suzanne&lastname=tennick
	 */

	@GetMapping(value = "/search/name", produces = "application/json")
	public Cittadino getByFirstnameAndLastname(@RequestParam(name = "firstname") String firstname,
			@RequestParam(name = "lastname") String lastname) {

		logger.info(
				"------------------ Fetched a single citizen element from firstname and  lastname ------------------");
		return citizen_service.selectByNomeAndCognome(firstname, lastname);
	}

	/*
	 * This method select a citizen in the database by ssn
	 * 
	 * @param ssn the ssn to search in the database
	 */
	@GetMapping(value = "/search/ssn", produces = "application/json")
	public Cittadino CittadinogetBySsn(@RequestParam(name = "ssn") String ssn) {

		logger.info("------------------ Fetched a single citizen element from ssn ------------------");
		return citizen_service.selectBySsn(ssn);
	}
}

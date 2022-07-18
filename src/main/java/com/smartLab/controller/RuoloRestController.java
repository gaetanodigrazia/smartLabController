/*
 * 
 * @see Ruolo.java
 * @see RuoloService.java
 * @see RuoloServiceImpl.java
 * @see RuoloRepository.java
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
import com.smartLab.service.RuoloService;
import com.smartLab.model.Ruolo;

/*
 * Role RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/ruoli")
public class RuoloRestController {
	private static final Logger logger = LoggerFactory.getLogger(RuoloRestController.class);

	@Autowired
	private CRUDService<Ruolo> crud_service;

	@Autowired
	private RuoloService<Ruolo> role_service;

	/*
	 * This method select all the roles in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Ruolo> listAllRoles() {
		List<Ruolo> all_roles = crud_service.getAll();
		logger.info("------------------ Fetching roles from database ------------------");
		logger.info("Record list size:  " + all_roles.size());

		return all_roles;
	}

	/*
	 * This method select a role from the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Ruolo getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single role element from id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new role in the database
	 * 
	 * @param role the role object to save
	 */
	@PostMapping
	public Ruolo createRole(@RequestBody Ruolo role) {
		logger.info("------------------ Create a role ------------------");
		return crud_service.create(role);
	}

	/*
	 * This method update a role in the database
	 * 
	 * @param role the role object data to update
	 * 
	 * @param id the id of the role to update
	 */
	@PutMapping
	public Ruolo updateRole(@RequestBody Ruolo role, int id) {
		logger.info("------------------ Update a booking ------------------");
		return crud_service.update(role, id);
	}

	/*
	 * This method delete a role from database
	 * 
	 * @param id the id of the role you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single role element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single role element by role name
	 * 
	 * @param role the role name to find in the database
	 * 
	 */
	@GetMapping(value = "nome/{role}", produces = "application/json")
	public Ruolo selectByName(@PathVariable(name = "role") String role) {

		logger.info("------------------ Fetched a role from name ------------------");
		return role_service.selectByName(role);
	}

}

/*
 * 
 * @see Categoria.java
 * @see CategoriaService.java
 * @see CategoriaServiceImpl.java
 * @see CategoriaRepository.java
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
import com.smartLab.service.PatologiaService;
import com.smartLab.model.Patologia;

/*
 * Category RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/patologie")
public class PatologiaRestController {
	private static final Logger logger = LoggerFactory.getLogger(PatologiaRestController.class);

	@Autowired
	private CRUDService<Patologia> crud_service;

	@Autowired
	private PatologiaService<Patologia> pathology_service;

	/*
	 * This method select all the category in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Patologia> listAllPathologies() {
		List<Patologia> all_pathologies = crud_service.getAll();
		logger.info("------------------ Fetching pathology list from database ------------------");
		logger.info("Record list size:  " + all_pathologies.size());

		return all_pathologies;
	}

	/*
	 * This method select a pathology in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Patologia getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single pathology element from id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new pathology in the database
	 * 
	 * @param pathology the pathology object to save
	 */
	@PostMapping
	public Patologia createCategory(@RequestBody Patologia pathology) {
		logger.info("------------------ Create a pathology ------------------");
		return crud_service.create(pathology);
	}

	/*
	 * This method update a pathology in the database
	 * 
	 * @param pathology the pathology object data to update
	 * 
	 * @param id the id of the pathology to update
	 */
	@PutMapping
	public Patologia updateCategory(@RequestBody Patologia pathology, int id) {
		logger.info("------------------ Update a pathology ------------------");
		return crud_service.update(pathology, id);
	}

	/*
	 * This method delete a category from database
	 * 
	 * @param id the id of the category you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single pathology element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single pathology element by pathology name
	 * 
	 * @param pathology the pathology name to find in the database
	 * 
	 */
	@GetMapping(value = "nome/{pathology_name}", produces = "application/json")
	public Patologia selectByName(@PathVariable(name = "pathology_name") String pathology_name) {

		logger.info("------------------ Fetched a pathology from name ------------------");
		return pathology_service.selectByName(pathology_name);
	}
	/*
	 * This method select a single pathology element by citizen id
	 * 
	 * @param id the id of the citizen whose pathology we are looking for
	 * 
	 */
	@GetMapping(value = "nome/byid/{id}", produces = "application/json")
	public Patologia selectByCitizenId(@PathVariable(name = "id") int id) {

		logger.info("------------------ Fetched a pathology from name ------------------");
		return pathology_service.selectByCitizenId(id);
	}

}

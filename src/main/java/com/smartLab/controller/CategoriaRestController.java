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
import com.smartLab.service.CategoriaService;
import com.smartLab.model.Categoria;

/*
 * Category RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/categorie")
public class CategoriaRestController {
	private static final Logger logger = LoggerFactory.getLogger(CategoriaRestController.class);

	@Autowired
	private CRUDService<Categoria> crud_service;

	@Autowired
	private CategoriaService<Categoria> category_service;

	/*
	 * This method select all the category in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Categoria> listAllBookings() {
		List<Categoria> all_bookings = crud_service.getAll();
		logger.info("------------------ Fetching category list from database ------------------");
		logger.info("Record list size:  " + all_bookings.size());

		return all_bookings;
	}

	/*
	 * This method select a category in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Categoria getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single category element from id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new category in the database
	 * 
	 * @param category the category object to save
	 */
	@PostMapping
	public Categoria createCategory(@RequestBody Categoria category) {
		logger.info("------------------ Create a category ------------------");
		return crud_service.create(category);
	}

	/*
	 * This method update a category in the database
	 * 
	 * @param category the category object data to update
	 * 
	 * @param id the id of the category to update
	 */
	@PutMapping
	public Categoria updateCategory(@RequestBody Categoria category, int id) {
		logger.info("------------------ Update a booking ------------------");
		return crud_service.update(category, id);
	}

	/*
	 * This method delete a category from database
	 * 
	 * @param id the id of the category you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single category element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single category element by category name
	 * 
	 * @param category the category name to find in the database
	 * 
	 */
	@GetMapping(value = "nome/{category_name}", produces = "application/json")
	public Categoria selectByName(@PathVariable(name = "category_name") String category_name) {

		logger.info("------------------ Fetched a category from name ------------------");
		return category_service.selectByName(category_name);
	}

}

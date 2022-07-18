/*
 * 
 * @see Prenotazione.java
 * @see PrenotazioneService.java
 * @see PrenotazioneServiceImpl.java
 * @see PrenotazioneRepository.java
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
import com.smartLab.service.PrenotazioneService;
import com.smartLab.model.Prenotazione;

/*
 * Booking RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/prenotazioni")
public class PrenotazioneRestController {
	private static final Logger logger = LoggerFactory.getLogger(PrenotazioneRestController.class);

	@Autowired
	private CRUDService<Prenotazione> crud_service;

	@Autowired
	private PrenotazioneService<Prenotazione> booking_service;

	/*
	 * This method select all the booking in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Prenotazione> listAllBookings() {
		List<Prenotazione> all_bookings = crud_service.getAll();
		logger.info("------------------ Fetching booking list from database ------------------");
		logger.info("Record list size:  " + all_bookings.size());

		return all_bookings;
	}

	/*
	 * This method select a citizen in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Prenotazione getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single booking element from id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new booking in the database
	 * 
	 * @param booking the booking object to save
	 */
	@PostMapping
	public Prenotazione createBooking(@RequestBody Prenotazione booking) {
		logger.info("------------------ Create a booking ------------------");
		return crud_service.create(booking);
	}

	/*
	 * This method update a booking in the database
	 * 
	 * @param booking the booking object data to update
	 * 
	 * @param id the id of the booking to update
	 */
	@PutMapping
	public Prenotazione updateBooking(@RequestBody Prenotazione booking, int id) {
		logger.info("------------------ Update a booking ------------------");
		return crud_service.update(booking, id);
	}

	/*
	 * This method delete a booking from database
	 * 
	 * @param id the id of the booking you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single booking element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single booking element by booking code
	 * 
	 * @param booking_code the booking_code to find in the database
	 * 
	 * Sample call: http://localhost:8080/prenotazioni?booking_code=AA0628100648AA
	 */
	@GetMapping(value = "/", produces = "application/json")
	public Prenotazione selectByBookingCode(@RequestParam(name = "booking_code") String booking_code) {

		logger.info("------------------ Fetched a single booking element from booking code ------------------");
		return booking_service.selectByBookingCode(booking_code);
	}

	/*
	 * This method select a single booking element by booking code
	 * 
	 * @param booking_code the booking_code to find in the database
	 * 
	 * Sample call: http://localhost:8080/prenotazioni?booking_code=AA0628100648AA
	 */
	@GetMapping(value = "/status/{status}", produces = "application/json")
	public List<Prenotazione> selectByStatus(@PathVariable(name = "status") int status) {

		logger.info("------------------ Fetched a list of booking archived or not ------------------");
		if (status == 1) {
			return booking_service.findByStatus(1);
		}
		return booking_service.findByStatus(0);
	}

}

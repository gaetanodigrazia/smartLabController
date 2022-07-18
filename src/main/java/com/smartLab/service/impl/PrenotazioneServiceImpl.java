/*
 * 
 * @see Prenotazione.java
 * @see PrenotazioneRestController.java
 * @see PrenotazioneRepository.java
 * @see PrenotazioneService.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartLab.exception.BadRequestException;
import com.smartLab.exception.NoDeletionException;
import com.smartLab.exception.ResourceNotFoundException;
import com.smartLab.model.Prenotazione;
import com.smartLab.repository.PrenotazioneRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.PrenotazioneService;

/*
 * BookingService class to manage transaction
 * 
 * */
@Service
@Transactional
public class PrenotazioneServiceImpl implements CRUDService<Prenotazione>, PrenotazioneService<Prenotazione> {

	@Autowired
	PrenotazioneRepository booking_repo;

	/*
	 * CRUD Method that check if a booking exists
	 * 
	 * @param id the id of the booking
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return booking_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all booking
	 * 
	 */
	@Override
	public List<Prenotazione> getAll() {
		// TODO Auto-generated method stub
		return booking_repo.findAll();
	}

	/*
	 * CRUD Method that select create a new booking
	 * 
	 * @param booking the booking to store in database
	 * 
	 */
	@Override
	public Prenotazione create(Prenotazione booking) {
		// TODO Auto-generated method stub
		if (exists(booking.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return booking_repo.save(booking);
	}

	/*
	 * CRUD Method that select a booking by booking id
	 * 
	 * @param id the id of the booking to search in the database
	 * 
	 */
	@Override
	public Prenotazione read(int id) {
		// TODO Auto-generated method stub
		return booking_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a booking by its own id
	 * 
	 * @param data the data of the booking to update
	 * 
	 * @param id the id of the booking to update
	 * 
	 */
	@Override
	public Prenotazione update(Prenotazione data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return booking_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a booking by booking id
	 * 
	 * @param id the id of the booking to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			booking_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * Method that access to PrenotazioneRepository class methods to select a
	 * booking by booking code
	 * 
	 * @param booking_code the booking_code to search in the database
	 * 
	 */
	public Prenotazione selectByBookingCode(String booking_code) {
		// TODO Auto-generated method stub
		return booking_repo.findByCodicePrenotazione(booking_code)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	@Override
	public List<Prenotazione> findByStatus(int status) {
		// TODO Auto-generated method stub
		return booking_repo.findByStatus(status);
	}

}

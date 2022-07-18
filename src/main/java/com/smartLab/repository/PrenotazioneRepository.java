/*
 * 
 * @see Prenotazione.java
 * @see PrenotazioneService.java
 * @see PrenotazioneServiceImpl.java
 * @see PrenotazioneRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartLab.model.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

	/*
	 * JPA method that select booking by its own booking code 
	 * 
	 * @param booking_code the booking_code to search in database
	 * */
	Optional<Prenotazione> findByCodicePrenotazione(String booking_code);
	
	/*
	 * JPA method that select bookings by status 
	 * 
	 * @param status the status of the booking to search for
	 * */
	List<Prenotazione> findByStatus(int status);
}

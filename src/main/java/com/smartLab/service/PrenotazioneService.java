/*
 * 
 * @see Prenotazione.java
 * @see PrenotazioneRepository.java
 * @see PrenotazioneServiceImpl.java
 * @see PrenotazioneRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

import java.util.List;


/*
 * Interface to make PrenotazioneServiceImp implements certain specific methods 
 * */
public interface PrenotazioneService<T>{
	
	
	/*
	 * Method that select a booking by its own booking code
	 * 
	 * @param booking_code the booking_code to search in the database
	 * */
	public T selectByBookingCode(String booking_code);
	

	/*
	 * Method that select bookings by status 
	 * 
	 * @param status the status of the booking to search for
	 * */
	public List<T> findByStatus(int status);
}

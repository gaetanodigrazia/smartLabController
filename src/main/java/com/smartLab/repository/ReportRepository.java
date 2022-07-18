/*
 * 
 * @see Report.java
 * @see ReportService.java
 * @see ReportServiceImpl.java
 * @see ReportRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartLab.model.Report;


public interface ReportRepository extends JpaRepository<Report, Integer> {
	

	/*
	 * JPA method that select a report by citizen ssn
	 * 
	 * */
	Optional<Report> findByCittadino(String ssn);

	/*
	 * JPA method that select a report by doctor ssn
	 * 
	 * */
	Optional<Report> findByMedico(String ssn);
	
	
	/*
	 * JPA method that select a report by booking code
	 * 
	 * */
	Optional<Report> findByPrenotazione(String booking_code);
	

	
}

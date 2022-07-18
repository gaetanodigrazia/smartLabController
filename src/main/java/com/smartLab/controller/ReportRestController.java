/*
 * 
 * @see Report.java
 * @see ReportService.java
 * @see ReportServiceImpl.java
 * @see ReportRepository.java
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
import com.smartLab.service.ReportService;
import com.smartLab.model.Report;

/*
 * Report RESTful controller class
 * 
 * */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/report")
public class ReportRestController {
	private static final Logger logger = LoggerFactory.getLogger(ReportRestController.class);

	@Autowired
	private CRUDService<Report> crud_service;

	@Autowired
	private ReportService<Report> report_service;

	/*
	 * This method select all the category in the database
	 * 
	 */
	@GetMapping(produces = "application/json")
	public List<Report> listAllReport() {
		List<Report> all_reports = crud_service.getAll();
		logger.info("------------------ Fetching category list from database ------------------");
		logger.info("Record list size:  " + all_reports.size());

		return all_reports;
	}

	/*
	 * This method select a report in the database by id
	 * 
	 * @param id the id to search in the database
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public Report getById(@PathVariable("id") int id) {
		logger.info("------------------ Fetching a single report element by id ------------------");
		return crud_service.read(id);
	}

	/*
	 * This method store a new category in the database
	 * 
	 * @param category the category object to save
	 */
	@PostMapping
	public Report createReport(@RequestBody Report report) {
		logger.info("------------------ Create a report ------------------");
		return crud_service.create(report);
	}

	/*
	 * This method update a report in the database
	 * 
	 * @param report the report object data to update
	 * 
	 * @param id the id of the report to update
	 */
	@PutMapping
	public Report updateReport(@RequestBody Report report, int id) {
		logger.info("------------------ Update a report ------------------");
		return crud_service.update(report, id);
	}

	/*
	 * This method delete a report from database
	 * 
	 * @param id the id of the report you want to delete
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		logger.info("------------------ Deleting a single report element ------------------");
		boolean deleted = crud_service.delete(id);
		if (deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(500).build();
	}

	/*
	 * This method select a single report element by booking code
	 * 
	 * @param booking_code the booking_code to find in the database
	 * 
	 * Sample call: http://localhost:8080/report?ssn_cittadino=AA0628100648AA
	 */
	@GetMapping(value = "/ssn/cittadino", produces = "application/json")
	public Report selectByCitizenSSN(@RequestParam(name = "ssn_cittadino") String citizen_ssn) {

		logger.info("------------------ Fetched report elements from citizen ssn code ------------------");
		return report_service.selectByPrenotazione(citizen_ssn);
	}

	/*
	 * This method select a single report element by booking code
	 * 
	 * @param booking_code the booking_code to find in the database
	 * 
	 * Sample call: http://localhost:8050/report?ssn_medico=AA0628100648AA
	 */
	@GetMapping(value = "/ssn/medico", produces = "application/json")
	public Report selectByDoctorSSN(@RequestParam(name = "ssn_medico") String doctor_ssn) {

		logger.info("------------------ Fetched report elements from doctor ssn code ------------------");
		return report_service.selectByPrenotazione(doctor_ssn);
	}

	/*
	 * This method select a single report element by booking code
	 * 
	 * @param booking_code the booking_code to find in the database
	 * 
	 * Sample call: http://localhost:8050/report?booking_code=AA0628100648AA
	 */
	@GetMapping(value = "/", produces = "application/json")
	public Report selectByBookingCode(@RequestParam(name = "booking_code") String booking_code) {

		logger.info("------------------ Fetched a single booking element from booking code ------------------");
		return report_service.selectByPrenotazione(booking_code);
	}

}

/*
 * 
 * @see Report.java
 * @see ReportRestController.java
 * @see ReportRepository.java
 * @see ReportService.java
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
import com.smartLab.model.Report;
import com.smartLab.repository.ReportRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.ReportService;

/*
 * ReportService class to manage transaction
 * 
 * */
@Service
@Transactional
public class ReportServiceImpl implements CRUDService<Report>, ReportService<Report> {

	@Autowired
	ReportRepository report_repo;

	/*
	 * CRUD Method that check if a report exists
	 * 
	 * @param id the id of the report
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return report_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all reports
	 * 
	 */
	@Override
	public List<Report> getAll() {
		// TODO Auto-generated method stub
		return report_repo.findAll();
	}

	/*
	 * CRUD Method that create and store a new report
	 * 
	 * @param report the report to store in database
	 * 
	 */
	@Override
	public Report create(Report report) {
		// TODO Auto-generated method report_repo
		if (exists(report.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return report_repo.save(report);
	}

	/*
	 * CRUD Method that select a report by report id
	 * 
	 * @param id the id of the report to search in the database
	 * 
	 */
	@Override
	public Report read(int id) {
		// TODO Auto-generated method stub
		return report_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a report by its own id
	 * 
	 * @param data the data of the report to update
	 * 
	 * @param id the id of the report to update
	 * 
	 */
	@Override
	public Report update(Report data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return report_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a report by report id
	 * 
	 * @param id the id of the report to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			report_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * ReportService method to select a report by citizen ssn
	 * 
	 * @param citizen_ssn the citizen ssn in the report to select from the database
	 * 
	 */
	@Override
	public Report selectByCittadino(String citizen_ssn) {
		// TODO Auto-generated method stub
		return report_repo.findByCittadino(citizen_ssn).orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * ReportService method to select a report by doctor ssn
	 * 
	 * @param doctor_ssn the doctor_ssn in the report to select from the database
	 * 
	 */
	@Override
	public Report selectByMedico(String doctor_ssn) {
		// TODO Auto-generated method stub
		return report_repo.findByMedico(doctor_ssn).orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * ReportService method to select a report by booking code
	 * 
	 * @param booking_code the booking_code of the report to select from the database
	 * 
	 */
	@Override
	public Report selectByPrenotazione(String booking_code) {
		// TODO Auto-generated method stub
		return report_repo.findByPrenotazione(booking_code).orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}




}

/*
 * 
 * @see Cittadino.java
 * @see CittadinoRestController.java
 * @see CittadinoRepository.java
 * @see CittadinoService.java
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

import com.smartLab.model.Cittadino;
import com.smartLab.repository.CittadinoRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.CittadinoService;
import com.smartLab.exception.BadRequestException;
import com.smartLab.exception.NoDeletionException;
import com.smartLab.exception.ResourceNotFoundException;

/*
 * Citizen service class to manage transaction
 * 
 * */
@Service
@Transactional
public class CittadinoServiceImpl implements CRUDService<Cittadino>, CittadinoService<Cittadino> {

	@Autowired
	CittadinoRepository citizen_repo;

	/*
	 * CRUD Method that check if a citizen exists
	 * 
	 * @param id the id of the citizen
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return citizen_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all citizen
	 * 
	 * @see CittadinoRepository.java
	 */
	@Override
	public List<Cittadino> getAll() {
		// TODO Auto-generated method stub
		return citizen_repo.findAll();
	}

	/*
	 * CRUD Method that select create a new citizen
	 * 
	 * @param citizen the citizen to store in database
	 * 
	 */
	@Override
	public Cittadino create(Cittadino cittadino) {
		// TODO Auto-generated method stub
		if (exists(cittadino.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return citizen_repo.save(cittadino);

	}

	/*
	 * CRUD Method that select a citizen by citizen id
	 * 
	 * @param id the id of the citizen to search in the database
	 * 
	 */
	@Override
	public Cittadino read(int id) {
		// TODO Auto-generated method stub
		return citizen_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a citizen by its own id
	 * 
	 * @param data the data of the citizen to update
	 * 
	 * @param id the id of the citizen to update
	 * 
	 */
	@Override
	public Cittadino update(Cittadino data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return citizen_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a citizen by citizen id
	 * 
	 * @param id the id of the citizen to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			citizen_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * Method that access to CittadinoRepository class methods to select a citizen
	 * by firstname and lastname
	 * 
	 * @param firstname the firstname of the citizen to search in database
	 * 
	 * @param lastname the lastname of the citizen to search in database
	 * 
	 * @see CittadinoRepository.java
	 */
	@Override
	public Cittadino selectByNomeAndCognome(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return citizen_repo.findByNomeAndCognome(firstname, lastname)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * Method that access to CittadinoRepository class methods to select a citizen
	 * by ssn
	 * 
	 * @param ssn the ssn to search in the database
	 * 
	 * @see CittadinoRepository.java
	 */
	@Override
	public Cittadino selectBySsn(String ssn) {
		// TODO Auto-generated method stub
		return citizen_repo.findBySsn(ssn)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * Method that access to CittadinoRepository class methods to select a citizen
	 * by email
	 * 
	 * @param email the email to search in the database
	 * 
	 * @see CittadinoRepository.java
	 */
	@Override
	public Cittadino selectByEmail(String email) {
		// TODO Auto-generated method stub
		return citizen_repo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

}

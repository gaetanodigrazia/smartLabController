/*
 * 
 * @see Prestazione.java
 * @see PrestazioneRestController.java
 * @see PrestazioneRepository.java
 * @see PrestazioneService.java
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
import com.smartLab.model.Prestazione;
import com.smartLab.repository.PrestazioneRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.PrestazioneService;

/*
 * CategoryService class to manage transaction
 * 
 * */
@Service
@Transactional
public class PrestazioneServiceImpl implements CRUDService<Prestazione>, PrestazioneService<Prestazione> {

	@Autowired
	PrestazioneRepository medical_service_repo;

	/*
	 * CRUD Method that check if a medical service exists
	 * 
	 * @param id the id of the medical service
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return medical_service_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all medical services
	 * 
	 */
	@Override
	public List<Prestazione> getAll() {
		// TODO Auto-generated method stub
		return medical_service_repo.findAll();
	}

	/*
	 * CRUD Method that select create a new medical service
	 * 
	 * @param medical_service the medical service to store in database
	 * 
	 */
	@Override
	public Prestazione create(Prestazione medical_service) {
		// TODO Auto-generated method stub
		if (exists(medical_service.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return medical_service_repo.save(medical_service);
	}

	/*
	 * CRUD Method that select a medical service by medical service id
	 * 
	 * @param id the id of the medical service to search in the database
	 * 
	 */
	@Override
	public Prestazione read(int id) {
		// TODO Auto-generated method stub
		return medical_service_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a medical service by its own id
	 * 
	 * @param data the data of the medical service to update
	 * 
	 * @param id the id of the medical service to update
	 * 
	 */
	@Override
	public Prestazione update(Prestazione data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return medical_service_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a medical service by medical service id
	 * 
	 * @param id the id of the medical service to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			medical_service_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * Method that select a medical service by its name
	 * 
	 * @param medical_service the medical service to search in the database
	 * 
	 */
	@Override
	public Prestazione selectByNome(String medical_service) {
		// TODO Auto-generated method stub
		return medical_service_repo.findByNome(medical_service)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this name not exist."));
	}

}

/*
 * 
 * @see Patologia.java
 * @see PatologiaRestController.java
 * @see PatologiaRepository.java
 * @see PatologiaService.java
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
import com.smartLab.model.Patologia;
import com.smartLab.repository.PatologiaRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.PatologiaService;

/*
 * Pathologyervice class to manage transaction
 * 
 * */
@Service
@Transactional
public class PatologiaServiceImpl implements CRUDService<Patologia>, PatologiaService<Patologia> {

	@Autowired
	PatologiaRepository pathology_repo;

	/*
	 * CRUD Method that check if a category exists
	 * 
	 * @param id the id of the category
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return pathology_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all category
	 * 
	 */
	@Override
	public List<Patologia> getAll() {
		// TODO Auto-generated method stub
		return pathology_repo.findAll();
	}

	/*
	 * CRUD Method that select create a new category
	 * 
	 * @param category the category to store in database
	 * 
	 */
	@Override
	public Patologia create(Patologia category) {
		// TODO Auto-generated method stub
		if (exists(category.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return pathology_repo.save(category);
	}

	/*
	 * CRUD Method that select a category by category id
	 * 
	 * @param id the id of the category to search in the database
	 * 
	 */
	@Override
	public Patologia read(int id) {
		// TODO Auto-generated method stub
		return pathology_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a category by its own id
	 * 
	 * @param data the data of the category to update
	 * 
	 * @param id the id of the category to update
	 * 
	 */
	@Override
	public Patologia update(Patologia data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return pathology_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a category by category id
	 * 
	 * @param id the id of the category to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			pathology_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * Method that select a pathology by its name
	 * 
	 * @param pathology the pathology of the pathology to search in the database
	 * 
	 */
	@Override
	public Patologia selectByName(String pathology) {
		// TODO Auto-generated method stub
		return pathology_repo.findByNome(pathology)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this name not exist."));
	}

	/*
	 * Method that select a pathology by citizen id
	 * 
	 *  @param id the id of the citizen whose pathology we are looking for
	 */
	@Override
	public Patologia selectByCitizenId(int id) {
		// TODO Auto-generated method stub
		return pathology_repo.findByCitizenId(id).orElse(null);
	}

}

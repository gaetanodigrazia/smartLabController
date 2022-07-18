/*
 * 
 * @see Categoria.java
 * @see CategoriaRestController.java
 * @see CategoriaRepository.java
 * @see CategoriaService.java
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
import com.smartLab.model.Ruolo;
import com.smartLab.repository.RuoloRepository;
import com.smartLab.service.CRUDService;
import com.smartLab.service.RuoloService;

/*
 * RuoloService class to manage transaction
 * 
 * */
@Service
@Transactional
public class RuoloServiceImpl implements CRUDService<Ruolo>, RuoloService<Ruolo> {

	@Autowired
	RuoloRepository role_repo;

	/*
	 * CRUD Method that check if a role exists
	 * 
	 * @param id the id of the role
	 * 
	 */
	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return role_repo.existsById(id);
	}

	/*
	 * CRUD Method that select all category
	 * 
	 */
	@Override
	public List<Ruolo> getAll() {
		// TODO Auto-generated method stub
		return role_repo.findAll();
	}

	/*
	 * CRUD Method that create a new role
	 * 
	 * @param role the role to store in database
	 * 
	 */
	@Override
	public Ruolo create(Ruolo role) {
		// TODO Auto-generated method stub
		if (exists(role.getId())) {
			throw new BadRequestException("Resource with this id already exists.");
		}
		return role_repo.save(role);
	}

	/*
	 * CRUD Method that select a role by role id
	 * 
	 * @param id the id of the role to search in the database
	 * 
	 */
	@Override
	public Ruolo read(int id) {
		// TODO Auto-generated method stub
		return role_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this id not exist."));
	}

	/*
	 * CRUD Method that update a role by its own id
	 * 
	 * @param data the data of the role to update
	 * 
	 * @param id the id of the role to update
	 * 
	 */
	@Override
	public Ruolo update(Ruolo data, int id) {
		// TODO Auto-generated method stub
		try {
			if (data.getId() != id)
				throw new BadRequestException("The ids of the object mismatch with passed id.");
			return role_repo.save(data);
		} catch (Exception e) {
			throw new ResourceNotFoundException("This resource not exist.");
		}
	}

	/*
	 * CRUD Method that delete a role by role id
	 * 
	 * @param id the id of the role to delete from the database
	 * 
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			role_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new NoDeletionException("Resource was not deleted due to an error.");
		}
	}

	/*
	 * Method that select a role by its name
	 * 
	 * @param role the role to search in the database
	 * 
	 */
	@Override
	public Ruolo selectByName(String role) {
		// TODO Auto-generated method stub
		return role_repo.findByNome(role)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with this name not exist."));
	}

}

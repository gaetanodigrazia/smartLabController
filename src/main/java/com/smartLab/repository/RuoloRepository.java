/*
 * 
 * @see Ruolo.java
 * @see RuoloService.java
 * @see RuoloServiceImpl.java
 * @see RuoloRestController.java
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

import com.smartLab.model.Ruolo;


public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {
	

	/*
	 * JPA method that select a role by its name
	 * 
	 * */
	Optional<Ruolo> findByNome(String name);

	
}

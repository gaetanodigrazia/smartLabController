/*
 * 
 * @see Cittadino.java
 * @see CittadinoService.java
 * @see CittadinoServiceImpl.java
 * @see CittadinoRestController.java
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

import com.smartLab.model.Cittadino;

public interface CittadinoRepository extends JpaRepository<Cittadino, Integer> {
	

	/*
	 * JPA method that select citizen by firstname and lastname
	 * 
	 * */
	Optional<Cittadino> findByNomeAndCognome(String firstname, String lastname);
	
	/*
	 * JPA method that select citizen by its own ssn 
	 * 
	 * */
	Optional<Cittadino> findBySsn(String ssn);
	
	/*
	 * JPA method that select citizen by its own email 
	 * 
	 * */
	Optional<Cittadino> findByEmail(String email);
	
}

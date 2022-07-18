/*
 * 
 * @see Prestazione.java
 * @see PrestazioneService.java
 * @see PrestazioneServiceImpl.java
 * @see PrestazioneRestController.java
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

import com.smartLab.model.Prestazione;


public interface PrestazioneRepository extends JpaRepository<Prestazione, Integer> {
	

	/*
	 * JPA method that select a medical service by its name
	 * 
	 * */
	Optional<Prestazione> findByNome(String name);

	
}

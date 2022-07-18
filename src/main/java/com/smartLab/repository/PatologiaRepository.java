/*
 * 
 * @see Patologia.java
 * @see PatologiaService.java
 * @see PatologiaServiceImpl.java
 * @see PatologiaRestController.java
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
import org.springframework.data.jpa.repository.Query;

import com.smartLab.model.Patologia;


public interface PatologiaRepository extends JpaRepository<Patologia, Integer> {
	

	/*
	 * JPA method that select a pathology by its name
	 * 
	 * */
	Optional<Patologia> findByNome(String name);
	
	/*
	 * Method that select a pathology by citizen id
	 * 
	 *  @param id the id of the citizen whose pathology we are looking for
	 */
	@Query(value = "SELECT * from patologia as p1, possesso as p2\r\n"
			+ "	where p1.id = p2.ref_patologia\r\n"
			+ "    AND p2.ref_cittadino = ?1", nativeQuery = true)
	Optional<Patologia> findByCitizenId(int id);

	
}

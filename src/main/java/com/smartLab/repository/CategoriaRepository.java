/*
 * 
 * @see Categoria.java
 * @see CategoriaService.java
 * @see CategoriaServiceImpl.java
 * @see CategoriaRestController.java
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

import com.smartLab.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	

	/*
	 * JPA method that select a category by its name
	 * 
	 * */
	Optional<Categoria> findByNome(String name);

	
}

/*
 * 
 * @see Categoria.java
 * @see CategoriaRepository.java
 * @see CategoriaServiceImpl.java
 * @see CategoriaRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make CategoriaServiceImp implements certain specific methods 
 * */
public interface CategoriaService<T> {

	/*
	 * Method that select a category by its own name
	 * 
	 * @param category the category to search in the database
	 */
	public T selectByName(String category);

}

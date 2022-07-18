/*
 * 
 * @see Patologia.java
 * @see PatologiaRepository.java
 * @see PatologiaServiceImpl.java
 * @see PatologiaRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make PatologiaServiceImp implements certain specific methods 
 * */
public interface PatologiaService<T> {

	/*
	 * Method that select a pathology by its own name
	 * 
	 * @param pathology the pathology to search in the database
	 */
	public T selectByName(String pathology);
	
	/*
	 * Method that select a pathology by citizen id
	 * 
	 *  @param id the id of the citizen whose pathology we are looking for
	 */
	public T selectByCitizenId(int id);

}

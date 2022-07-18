/*
 * 
 * @see Prestazione.java
 * @see PrestazioneRepository.java
 * @see PrestazioneServiceImpl.java
 * @see PrestazioneRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make PrestazioneServiceImp implements certain specific methods 
 * */
public interface PrestazioneService<T> {

	/*
	 * Method that select a medical service by its own name
	 * 
	 * @param medical_service the medical service to search in the database
	 */
	public T selectByNome(String medical_service);

}

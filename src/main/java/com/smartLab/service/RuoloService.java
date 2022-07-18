/*
 * 
 * @see Ruolo.java
 * @see RuoloRepository.java
 * @see RuoloServiceImpl.java
 * @see RuoloRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make RuoloServiceImp implements certain specific methods 
 * */
public interface RuoloService<T> {

	/*
	 * Method that select a role by its own name
	 * 
	 * @param role the role to search in the database
	 */
	public T selectByName(String role);

}

/*
 * 
 * @see Cittadino.java
 * @see CittadinoRepository.java
 * @see CittadinoServiceImpl.java
 * @see CittadinoestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make CittadinoServiceImp implements certain specific methods 
 * */
public interface CittadinoService<T> {

	/*
	 * Method that select a citizen by its own firstname and lastname
	 * 
	 * @param firstname the firstname to search in the database
	 * 
	 * @param lastname the lastname to search in the database
	 */
	public T selectByNomeAndCognome(String firstname, String lastname);

	/*
	 * Method that select a citizen by its own ssn
	 * 
	 * @param ssn the ssn to search in the database
	 */
	public T selectBySsn(String ssn);

	/*
	 * Method that select a citizen by its own email
	 * 
	 * @param email the email to search in the database
	 */
	public T selectByEmail(String email);

}

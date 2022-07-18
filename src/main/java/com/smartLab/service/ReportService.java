/*
 * 
 * @see Report.java
 * @see ReportRepository.java
 * @see ReportServiceImpl.java
 * @see ReportRestController.java
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

/*
 * Interface to make ReportServiceImp implements certain specific methods 
 * */
public interface ReportService<T> {

	/*
	 * Method that select a report by citizen ssn
	 * 
	 * @param citizen_ssn the citizen ssn to search in the database
	 */
	public T selectByCittadino(String citizen_ssn);
	
	/*
	 * Method that select a report by doctor ssn
	 * 
	 * @param doctor_ssn the doctor ssn to search in the database
	 */
	public T selectByMedico(String doctor_ssn);
	
	/*
	 * Method that select a report by its booking code
	 * 
	 * @param booking_code the booking_code to search in the database
	 */
	public T selectByPrenotazione(String booking_code);

}

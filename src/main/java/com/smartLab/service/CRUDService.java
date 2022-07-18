/*
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */
package com.smartLab.service;

import java.util.List;

/*
 * Interface to make class implements general CRUD Methods 
 * */
public interface CRUDService<T> {

	/*
	 * CRUD method that check if an object exists in the database
	 * 
	 *  @param id the id of the element to search for
	 * */
	public boolean exists(int id);

	/*
	 * CRUD method that retrieve all the <T> object in the database
	 * 
	 * */
	public List<T> getAll();

	/*
	 * CRUD method that create and store an object into the database
	 * 
	 *  @param object the object to store
	 * */
	public T create(T object);

	/*
	 * CRUD method that create and store an object into the database
	 * 
	 *  @param object the object to store
	 * */
	T read(int id);

	/*
	 * CRUD method that update an object from database
	 * 
	 *  @param data the data (all, even the unupdated) of object to update
	 *  @param id the id of the object to update
	 * */
	public T update(T data, int id);

	
	/*
	 * CRUD method that delete an object from database
	 * 
	 *  @param id the id of the object to delete
	 * */
	public boolean delete(int id);

}

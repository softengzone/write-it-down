package com.softengzone.api.wid.service;

import java.util.List;

import com.softengzone.api.wid.exception.ObjectNotFoundException;

public interface Service<T, ID> {
	
	List<T> findAll();

	T findById(ID id) throws ObjectNotFoundException;

	T save(T t);

	void delete(T t);	
	
	void deleteAll();
	
}

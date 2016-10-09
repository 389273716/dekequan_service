package com.dekequan.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {

	
	public T findById(Object keyId);
	
	public int save(T entity);
	
	public int deleteById(Object keyId);
	
	public int update(T entity);
	
	public List<T> findByQuery(Object query);
	
}

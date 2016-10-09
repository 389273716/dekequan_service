package com.dekequan.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
 * <p>
 * 介绍 基础功能接口
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月10日 上午1:25:28
 * @version 1.0
 * @param <T>
 */
@Service
public interface BaseService<T> {

	public T findById(Object keyId);

	public int save(T entity);

	public int deleteById(Object keyId);

	public int update(T entity);

	public List<T> findByQuery(Object query);

}

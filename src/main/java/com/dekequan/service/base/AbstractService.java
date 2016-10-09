package com.dekequan.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * <p>介绍 service 常用操作基类</p>
 * @author 唐太明
 * @date 2016年10月10日 上午1:23:58
 * @version 1.0
 * @param <T>
 */
public abstract class AbstractService<T> implements BaseService<T> {

	@Autowired
	private Mapper<T> mMapper;
	
	public T findById(Object keyId) {
		return mMapper.selectByPrimaryKey(keyId);
	}
	
	public int save(T entity) {
		return mMapper.insert(entity);
	}
	
	public int deleteById(Object keyId) {
		return mMapper.deleteByPrimaryKey(keyId);
	}
	
	public int update(T entity) {
		return mMapper.updateByPrimaryKey(entity);
	}
	
	public List<T> findByQuery(Object query) {
		return mMapper.selectByExample(query);
	}
	
}

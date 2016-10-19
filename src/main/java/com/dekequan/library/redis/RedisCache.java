/**
 * 
 */
package com.dekequan.library.redis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache extends RedisCacheBasic {
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	public void set(String key, String value) {
		set(key, value, this.redisTemplate);
	}
	
	public void set(String key, String value, Long expireSec) {
		set(key, value, expireSec, this.redisTemplate);
	}

	public String get(String key) {
		return get(key, this.redisTemplate);
	}

	public void delete(String key) {
		delete(key, this.redisTemplate);
	}

	public void deleteByTag(String key) {
		deleteByTag(key, this.redisTemplate);
	}

	public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}

/**
 * 
 */
package com.dekequan.library.redis;

import java.io.Serializable;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author tomtop2029
 *
 */
@SuppressWarnings(value={"unchecked","rawtypes"})
public class RedisCacheBasic {

	private long expireSecs;//失效时间

	public RedisCacheBasic() {
		this.expireSecs = 86400L;//不设置，则默认24h
	}
	/**
	 * 向键为key的组合设置值
	 * @param key
	 * @param value
	 * @param redisTemplate
	 */
	public void set(final String key,final String value,final RedisTemplate<Serializable, Serializable> redisTemplate) {
		try {
			redisTemplate.execute(new RedisCallback() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					if (("" == value) || (null == value) || ("null".equals(value))) {
						return null;
					}
					byte[] sk = redisTemplate.getStringSerializer().serialize(key);
					connection.set(sk, redisTemplate.getStringSerializer().serialize(value));

					connection.expire(sk, RedisCacheBasic.this.expireSecs);

					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置键值并设置失效时间
	 * @param key
	 * @param value
	 * @param expireSecs     失效时间(单位：秒)
	 * @param redisTemplate
	 */
	public void set(final String key,final String value,final Long expireSecs,final RedisTemplate<Serializable, Serializable> redisTemplate) {
		try {
			redisTemplate.execute(new RedisCallback() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					if (("" == value) || (null == value) || ("null".equals(value))) {
						return null;
					}
					byte[] sk = redisTemplate.getStringSerializer().serialize(key);
					connection.set(sk, redisTemplate.getStringSerializer().serialize(value));

					connection.expire(sk, expireSecs);

					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据键名获取值
	 * @param key
	 * @param value
	 * @param redisTemplate
	 * @return
	 */
	public String get(final String key, final RedisTemplate<Serializable, Serializable> redisTemplate) {
		try {
			return ((String) redisTemplate.execute(new RedisCallback() {
				public String doInRedis(RedisConnection connection) throws DataAccessException {
					byte[] sk = redisTemplate.getStringSerializer().serialize(key);
					if (connection.exists(sk).booleanValue()) {
						byte[] sv = connection.get(sk);
						return ((String) redisTemplate.getStringSerializer().deserialize(sv));
					}
					return null;
				}
			}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除对应键值组合
	 * @param key
	 * @param value
	 * @param redisTemplate
	 */
	public void delete(final String key, final RedisTemplate<Serializable, Serializable> redisTemplate) {
		redisTemplate.execute(new RedisCallback() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(new byte[][] { redisTemplate.getStringSerializer().serialize(key) });

				return null;
			}
		});
	}

	/**
	 * 模糊匹配删除
	 * @param key
	 * @param value
	 * @param redisTemplate
	 */
	public void deleteByTag(final String key, final RedisTemplate<Serializable, Serializable> redisTemplate) {
		redisTemplate.execute(new RedisCallback() {
			public Object doInRedis(RedisConnection connection) {
				Set<byte[]> keys = connection.keys(redisTemplate.getStringSerializer().serialize(key + "*"));
				for (byte[] k : keys) {
					connection.del(new byte[][] { k });
				}
				return null;
			}
		});
	}

	public long getExpireSecs() {
		return this.expireSecs;
	}

	public void setExpireSecs(long expireSecs) {
		this.expireSecs = expireSecs;
	}

}

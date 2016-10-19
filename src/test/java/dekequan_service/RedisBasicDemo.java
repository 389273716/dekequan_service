/**
 * 
 */
package dekequan_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dekequan.library.redis.RedisCache;
import com.dekequan.library.utils.SpringContextHelper;

/**
 * @author tomtop2029
 *
 */
public class RedisBasicDemo extends BaseDemo{
	@Autowired
	private RedisCache redisCache;
	
	@Test
	public void testRedis(){
//		RedisCache redisCache = SpringContextHelper.getBean("redisCache");
		redisCache.set("name", "ttm");
		String value = redisCache.get("name");
		System.out.println(value);
	}
}

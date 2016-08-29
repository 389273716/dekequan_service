package dekequan_service.fun;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dekequan.orm.User;
import com.dekequan.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/com/dekequan/spring/applicationContext.xml")
public class UserDemo {

	@Resource
	private UserService userServiceImpl;
	
	@Test
	public void saveTest() {
		User user = new User();
		user.setUserName("x1");
		user.setPassword("123");
		user.setNickName("x11");
		user.setRank(1);
		user.setLevel(1);
		user.setImg("http://***.jpg");
		user.setCreateTime("2015-12-12 00:00:00");
		user.setAccessToken("t-nc-dt");
		user.setDkToken("t-nc-dt");
		user.setExpireTime("2016-12-12 00:00:00");
		user.setSex(1);
		userServiceImpl.save(user);
		System.out.println("^^^^^^^^^^^^^^success");
//		System.out.println(userServiceImpl.toString());
	}
	
}

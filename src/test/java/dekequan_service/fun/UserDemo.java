package dekequan_service.fun;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dekequan.base.ResponseBase;
import com.dekequan.dao.UserDao;
import com.dekequan.library.Print;
import com.dekequan.orm.User;
import com.dekequan.service.UserService;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/com/dekequan/spring/applicationContext.xml")
public class UserDemo {

//	@Resource
//	private UserService userServiceImpl;
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 保存用户
	 */
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
//		userServiceImpl.save(user);
		System.out.println("^^^^^^^^^^^^^^success");
//		System.out.println(userServiceImpl.toString());
	}
	
	/**
	 * id查询用户数据
	 */
	public void findUserTest() {
//		int userId = 1;
//		User partUser = userServiceImpl.querySingleUser(userId);
//		Print.print(userServiceImpl.constructResultUserCenter(partUser));
	}
	
	@Test
	public void loginUserTest() {
		String userName = "x1";
		String password = "1231";
		Map<String, String> query = new HashMap<String, String>();
		query.put("userName", userName);
		query.put("password", password);
//		User partUser = userDao.findUserByLogin();
//		ResponseBase<Map<String, Object>> partResponse = userServiceImpl.constructResultLogin(partUser);
		Print.print(userDao.findUserById(1));
	}
	
}

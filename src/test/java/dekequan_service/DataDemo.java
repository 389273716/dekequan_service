package dekequan_service;

import com.dekequan.dao.user.UserDaoIm;
import com.dekequan.library.utils.Print;
import com.dekequan.service.user.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/dekequan/spring/applicationContext.xml", "classpath:/com/dekequan/spring/dispatcher-servlet.xml"})
public class DataDemo {

	@Resource
	private BasicDataSource dataSource;

	@Autowired
	private UserService userService;
	
	//数据库连接测试
	@Test
	public void dbTest() throws SQLException {
//		System.out.println(dataSource.getConnection());
//		Print.print(userService.fetchSimpleUserById(1));
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/dekequan/spring/applicationContext.xml");
//		SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) context.getBean("sqlSessionTemplate");
		UserDaoIm userDaoIm = new UserDaoIm();
//		Print.print(userDaoIm.get(QueryHelper.where("userId", QueryHelper.EQ, 1)));
		Print.print(userDaoIm.get(1));
	}
	
}

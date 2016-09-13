package dekequan_service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/com/dekequan/spring/applicationContext.xml")
public class DataDemo {

	@Resource
	private BasicDataSource dataSource;
	
	//数据库连接测试
	@Test
	public void dbTest() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	
}

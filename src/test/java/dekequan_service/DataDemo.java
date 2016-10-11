package dekequan_service;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.Print;
import com.dekequan.orm.smart.Demo;
import com.dekequan.service.smart.DemoService;

public class DataDemo extends BaseDemo {
	
	@Autowired
	private DemoService demoServiceImpl;
	
	@Test
	public void dbTest() throws SQLException {
	}
	
}

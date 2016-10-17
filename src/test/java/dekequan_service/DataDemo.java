package dekequan_service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.Module;
import com.dekequan.service.permissions.ModuleService;

public class DataDemo extends BaseDemo {
	
	@Autowired
	private ModuleService moduleServiceImpl;
	
	@Test
	public void dbTest() throws SQLException {
		List<Module> partModuleList = moduleServiceImpl.findModuleListByUser(1);
		System.out.println("ttm | 查询数据:" + partModuleList.size());
		Print.print(partModuleList);
	}
	
}

package dekequan_service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.MyDate;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.Module;
import com.dekequan.service.permissions.ModuleService;

public class ModelDemo extends BaseDemo {

	@Autowired
	private ModuleService moduleServiceImpl;
	
	/**
	 * 查询所有方法
	 */
	public void findModuleList() {
		List<Module> partModuleList = moduleServiceImpl.findModuleList();
		System.out.println("ttm | module size:" + partModuleList.size());
		Print.print(partModuleList);
	}
	
	/**
	 * 保存方法
	 */
	@Test
	public void saveModule() {
		Module partModuleRow = new Module();
		partModuleRow.setName("友盟统计");
		partModuleRow.setFlag("p");
		partModuleRow.setSortNo(10);
		partModuleRow.setUrl("http://127.0.0.1:10002/privilege-server");
		
		MyDate partMyDate = new MyDate();
		partModuleRow.setCreateTime(partMyDate.getCurrentDateTime());
		System.out.println("ttm | 保存数据");
		Print.print(partModuleRow);
		Integer partRow = moduleServiceImpl.saveModule(partModuleRow);
		if (partRow.equals(1)) {
			System.out.println("ttm | 保存成功");
		} else {
			System.out.println("ttm | 保存失败");
		}
	}
	
}

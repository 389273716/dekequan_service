package dekequan_service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.MyDate;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.Role;
import com.dekequan.service.permissions.RoleService;

public class RoleDemo extends BaseDemo {

	@Autowired
	private RoleService roleServiceImpl;
	
	@Test
	public void saveRoleDemo() {
		Role partRole = new Role();
		partRole.setName("社区管理员");
		
		MyDate partMyDate = new MyDate();
		partRole.setCreateTime(partMyDate.getCurrentDateTime());
		partRole.setUpdateTime(partMyDate.getCurrentDateTime());
		System.out.println("ttm | 打印结构");
		Print.print(partRole);
		Integer partRow = roleServiceImpl.saveRole(partRole);
		if (partRow.equals(1)) {
			System.out.println("ttm | 保存成功...");
		} else {
			System.out.println("ttm | 保存失败...");
		}
	}
	
}

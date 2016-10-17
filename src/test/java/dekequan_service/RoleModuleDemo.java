package dekequan_service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.RoleModule;
import com.dekequan.orm.permissions.UserRole;
import com.dekequan.service.permissions.RoleModuleService;

public class RoleModuleDemo extends BaseDemo {

	@Autowired
	private RoleModuleService roleModuleServiceImpl;
	
	@Test
	public void saveUserRole() {
		for (int x = 1; x <= 4; x++) {
			RoleModule partUM = new RoleModule();
			partUM.setRoleId(1);
			partUM.setModuleId(x);
			
			System.out.println("ttm | 保存数据:" + x);
			Print.print(partUM);
			Integer partRow = roleModuleServiceImpl.saveRoleModule(partUM);
			if (partRow.equals(1)) {
				System.out.println("ttm | 保存成功");
			} else {
				System.out.println("ttm | 保存失败");
			}
		}
	}
	
}

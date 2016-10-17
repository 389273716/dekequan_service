package dekequan_service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.UserRole;
import com.dekequan.service.permissions.UserRoleService;

public class UserRoleDemo extends BaseDemo {

	@Autowired
	private UserRoleService userRoleServiceImpl;
	
	@Test
	public void saveUserRole() {
		for (int x = 1; x <= 4; x++) {
			UserRole partUR = new UserRole();
			partUR.setUserId(1);
			partUR.setRoleId(x);
			
			System.out.println("ttm | 保存数据:" + x);
			Print.print(partUR);
			Integer partRow = userRoleServiceImpl.saveUserRole(partUR);
			if (partRow.equals(1)) {
				System.out.println("ttm | 保存成功");
			} else {
				System.out.println("ttm | 保存失败");
			}
		}
	}
	
}

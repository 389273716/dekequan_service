package dekequan_service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dekequan.library.utils.MD5Helper;
import com.dekequan.library.utils.MyDate;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.user.AdminUser;
import com.dekequan.service.user.AdminUserService;

public class AdminUserDemo extends BaseDemo {

	@Autowired
	private AdminUserService adminUserServiceImpl;
	
	@Test
	public void saveAdminUserTest() {
		AdminUser partAU = new AdminUser();
		partAU.setUserName("root");
		
		partAU.setPassword(MD5Helper.encode("tangtaiming123"));
		partAU.setName("超级管理员");
		partAU.setSex(1);
		partAU.setIsAdmin(1);
		partAU.setIsLock(0);
		partAU.setIsDelete(0);
		
		MyDate partMyDate = new MyDate();
		partAU.setCreateTime(partMyDate.getCurrentDateTime());
		partAU.setUpdateTime(partMyDate.getCurrentDateTime());
		System.out.println("ttm | 保存数据");
		Print.print(partAU);
		Integer partRow = adminUserServiceImpl.saveAdminUser(partAU);
		if (partRow.equals(1)) {
			System.out.println("ttm | 保存成功");
		} else {
			System.out.println("ttm | 保存失败");
		}
	}
	
}

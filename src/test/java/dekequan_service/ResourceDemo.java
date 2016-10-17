package dekequan_service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.dekequan.library.utils.MyDate;
import com.dekequan.library.utils.Print;
import com.dekequan.orm.permissions.Resource;
import com.dekequan.service.permissions.ResourceService;

/**
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午10:23:22
 * @version 1.0
 */
public class ResourceDemo extends BaseDemo {

	@Autowired
	private ResourceService resourceServiceImpl;

	/**
	 * 权限保存
	 */
	public void saveResource() {
		Resource partResource = new Resource();
		partResource.setName("权限管理");
		partResource.setUrl("/controller/resource/list.do");
		partResource.setParentId(0);
		partResource.setStructure("s-2");
		partResource.setSortNo(2);
		partResource.setModuleFlag("p");
		
		MyDate partMyDate = new MyDate();
		partResource.setCreateTime(partMyDate.getCurrentDateTime());
		partResource.setUpdateTime(partMyDate.getCurrentDateTime());
		System.out.println("ttm | 保存数据结构");
		Print.print(partResource);
		Integer partRow = resourceServiceImpl.saveResouce(partResource);
		if (partRow.equals(1)) {
			System.out.println("ttm | 保存成功");
		} else {
			System.out.println("ttm | 保存失败");
		}
	}
	
	/**
	 * 权限查询
	 */
	@Test
	public void findResourceListTest() {
		List<String> partModuflag = new ArrayList<String>();
		partModuflag.add("p");
		Integer partUserId = 3;
		List<Resource> partResourceList = resourceServiceImpl.findResourceListByModuleFlag(partModuflag, partUserId);
		if (CollectionUtils.isEmpty(partResourceList)) {
			System.out.println("ttm | 查询数据为空...");
		} else {
			System.out.println("ttm | 查询数据数量:" + partResourceList.size());
			Print.print(partResourceList);
		}
		
	}

}

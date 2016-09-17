/**
 * 
 */
package com.dekequan.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dekequan.orm.menu.Menu;

/**
 * @author qzr
 * 菜谱业务层接口
 */
@Service
public interface MenuService {
	/**
	 * 查询指定页的菜谱列表
	 * @param pageSize             页数
	 * @param pageNumber       一页的Listing条数
	 * @return
	 */
	public abstract List<Menu> fetchMenuList(int pageSize, int pageNumber);
}

/**
 * 
 */
package com.dekequan.service.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.menu.MenuDao;
import com.dekequan.orm.menu.Menu;
import com.dekequan.service.menu.MenuService;

/**
 * @author qzr
 * 菜谱业务层接口实现
 */
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuDao menuDaoImpl;
	
	@Override
	public List<Menu> fetchMenuList(int pageSize, int pageNumber) {
		return menuDaoImpl.fetchList(pageNumber, pageSize);
	}

}

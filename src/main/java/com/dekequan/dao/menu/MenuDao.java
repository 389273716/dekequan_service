/**
 * 
 */
package com.dekequan.dao.menu;

import java.util.List;

import com.dekequan.orm.menu.Menu;

/**
 * @author qzr
 *  菜单数据层接口
 */
public interface MenuDao {
	
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> fetchList(int pageNumber, int pageSize);

}

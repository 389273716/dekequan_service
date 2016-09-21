package com.dekequan.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.base.ResponseBase;
import com.dekequan.base.ResponseRe;
import com.dekequan.dao.user.UserDao;
import com.dekequan.library.utils.Json;
import com.dekequan.library.utils.MyDate;
import com.dekequan.library.utils.SystemTokenUtil;
import com.dekequan.library.utils.UserUtil;
import com.dekequan.orm.community.Article;
import com.dekequan.orm.menu.Menu;
import com.dekequan.orm.user.SimpleUser;
import com.dekequan.orm.user.User;
import com.dekequan.service.user.UserService;

/**
 * <p>
 * </p>
 * @author TTM
 * @date 2016年8月28日 上午2:01:07
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDaoImpl;
	
	public User querySingleUser(Integer id) {
		return userDaoImpl.findUserById(id);
	}
	
	public boolean save(User user) {
		userDaoImpl.saveUser(user);
		return true;
	}
	
	/**
	 * 个人接口
	 * @return
	 */
	public ResponseBase<Map<String, Object>> constructResultUserCenter(User user) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		if (user == null) {
			return responseToError();
		}
		
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		Map<String, Object> partData = new LinkedHashMap<String, Object>();
		partData.put("userId", user.getUserId());
		partData.put("userName", user.getUserName());
		partData.put("nickName", user.getNickName());
		partData.put("rank", user.getRank());
		partData.put("level", user.getLevel());
		partData.put("img", user.getImg());
		
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(partData);
		return partResponse;
	}
	
	public User login(String userName, String password) {
		Map<String, String> partQuery = new HashMap<String, String>();
		partQuery.put("userName", userName);
		partQuery.put("password", password);
		User partUser = userDaoImpl.findUserByLogin(partQuery);
		return partUser;
	}
	
	@Override
	public boolean logout(Integer userId) {
		User partUser = querySingleUser(userId);
		if (partUser == null) {
			return false;
		}
		
		MyDate partMyDate = new MyDate();
		Map<String, String> partQuery = new HashMap<String, String>();
		partQuery.put("userId", userId.toString());
		partQuery.put("expireTime", partMyDate.getCurrentDateTime());
		userDaoImpl.updateUserExpireTime(partQuery);
		return true;
	}
	
	@Override
	public boolean modifyUserInfo(Map<String, Object> query) {
		String partId = query.get("id").toString();
		User partUser = querySingleUser(Integer.valueOf(partId));
		System.out.println("^^^^^^^^^json:" + Json.toJson(partUser));
		if (partUser == null) {
			return false;
		}
//		Map<String, Object> partQuery = new HashMap<String, Object>();
//		partQuery.put("userId", Integer.valueOf(query.get("id")));
//		partQuery.put("nickName", query.get("nickName"));
//		partQuery.put("sex", Integer.valueOf(query.get("sex")));
//		partQuery.put("img", query.get("img"));
		userDaoImpl.updateUser(query);
		return true;
	}

	public ResponseBase<Map<String, Object>> constructResultLogin(User user) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		if (user == null) {
			return responseToError();
		}
		
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		Map<String, Object> partData = new LinkedHashMap<String, Object>();
		partData.put("token", user.getDkToken());
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(partData);
		return partResponse;
	}

	public ResponseBase<Map<String, Object>> responseToError() {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();

		Integer partRe = ResponseRe.RE_NO_DATA;
		String partMsg = "NO_DATA";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(new HashMap<String, Object>());
		return partResponse;
	}

	public User register(String userName, String password){
		Map<String, String> partQuery = new HashMap<String, String>();
		partQuery.put("userName", userName);
		User exist = userDaoImpl.findUserByLogin(partQuery);
		if(null != exist){
			return null;
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
//		user.setCreateTime();
		user.setDkToken(SystemTokenUtil.generateSysToken());
//		user.setExpireTime(expireTime);
//		user.setLevel(level);
		user.setNickName(UserUtil.DEFAULT_NICK_NAME);
//		user.setRank(rank);
		user.setSex(UserUtil.DEFAULT_SEX);
		
		return user;
	}
	
	public ResponseBase<Map<String, Object>> userExistError() {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();
		Integer partRe = ResponseRe.RE_FAILURE;
		String partMsg = "USER_EXIST";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(new HashMap<String, Object>());
		
		return partResponse;
	}

	@Override
	public ResponseBase<Map<String, Object>> constructResultRegister(User user) {
		ResponseBase<Map<String, Object>> response = new ResponseBase<Map<String,Object>>();
		if(null == user){
			return userExistError();
		}
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		Map<String, Object> partData = new LinkedHashMap<String, Object>();
		partData.put("token", user.getDkToken());
		response.setRe(partRe);
		response.setMsg(partMsg);
		response.setData(partData);
		return response;
	}

	@Override
	public ResponseBase<Map<String, Object>> constructCheckCodeError() {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();
		Integer partRe = ResponseRe.RE_FAILURE;
		String partMsg = "CHECK_CODE__ERROR";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(new HashMap<String, Object>());
		return partResponse;
	}

	@Override
	public ResponseBase<Map<String, Object>> constructReturnLogout() {
		return constructSuccess(new HashMap<String, Object>());
	}

	@Override
	public ResponseBase<Map<String, Object>> constructReturnUserInfo() {
		return constructSuccess(new HashMap<String, Object>());
	}
	
	/**
	 * 构建成功
	 * @return
	 */
	private ResponseBase<Map<String, Object>> constructSuccess(Map<String, Object> obj) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();
		Integer partRe = ResponseRe.RE_SUCCESS;
		String partMsg = "SUCCESS";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(obj);
		return partResponse;
	}

	@Override
	public SimpleUser fetchSimpleUserById(Integer userId) {
//		Print.print();
		return userDaoImpl.fetchSimpleUserById(userId);
	}
	
	/**
	 * 我的发布
	 */
	@Override
	public SimpleUser myPublished(String dkToken) {
		return userDaoImpl.fetchSimpleUserByToken(dkToken);
	}
	/**
	 * 构建我的发布返回值
	 */
	@Override
	public ResponseBase<Map<String, Object>> constructReturnMyPublished(
			SimpleUser user, List<Menu> menus, List<Article> articles) {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();
		partResponse.setMsg("SUCCESS");
		partResponse.setRe(ResponseRe.RE_SUCCESS);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("img", user.getImg());
		dataMap.put("nickname", user.getNickName());
		dataMap.put("rankName", user.getRankName());
//		dataMap.put("fansCount", user.get);
		dataMap.put("userMenuCount", menus.size());
		dataMap.put("userArticalCount", articles.size());
		List<Map<String, Object>> menuDatas = new ArrayList<Map<String,Object>>();
		for(Menu menu : menus){
			Map<String, Object> menuData = new HashMap<String, Object>();
			menuData.put("menuId", menu.getMainImage());
			menuData.put("title", menu.getTitle());
			menuData.put("mainImage", menu.getMainImage());
			menuData.put("viewCount", menu.getViewCount());
//			menuData.put("userCollectCount", );
			menuDatas.add(menuData);
		}
		dataMap.put("menus", menuDatas);
		List<Map<String, Object>> articleDatas = new ArrayList<Map<String,Object>>();
		for(Article article : articles){
			Map<String, Object> articleData = new HashMap<String, Object>();
			articleData.put("aticleId", article.getAticleId());
			articleData.put("title", article.getTitle());
			articleData.put("mainImage", article.getMainImage());
			articleData.put("createTime", article.getCreateTime());
//			articleData.put("followCount", article.get);
//			articleData.put("commentCount", article.getc);
			articleData.put("likeCount", article.getLikeCount());
			articleDatas.add(articleData);
		}
		dataMap.put("articals", articleDatas);
		return partResponse;
	}

	@Override
	public ResponseBase<Map<String, Object>> constructFindNoInfoError() {
		ResponseBase<Map<String, Object>> partResponse = new ResponseBase<Map<String, Object>>();
		Integer partRe = ResponseRe.RE_FAILURE;
		String partMsg = "FIND_NO_DATA_ERROR";
		partResponse.setRe(partRe);
		partResponse.setMsg(partMsg);
		partResponse.setData(new HashMap<String, Object>());
		return partResponse;
	}

}

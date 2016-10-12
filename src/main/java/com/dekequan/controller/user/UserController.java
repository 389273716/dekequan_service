package com.dekequan.controller.user;

import java.util.List;
import java.util.Map;

import javax.batch.api.partition.PartitionAnalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dekequan.library.response.ResponseBase;
import com.dekequan.library.response.ResponseRe;
import com.dekequan.library.utils.Json;
import com.dekequan.library.utils.UserUtil;
import com.dekequan.orm.community.Article;
import com.dekequan.orm.menu.Menu;
import com.dekequan.orm.user.SimpleUser;
import com.dekequan.orm.user.User;
import com.dekequan.service.community.ArticleService;
import com.dekequan.service.menu.MenuService;
import com.dekequan.service.user.UserService;

/**
 * @author qzr + ttm + sj
 *
 */
@Controller
@RequestMapping(value = "/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired	
	private MenuService menuService;
	@Autowired
	private ArticleService articleService;
	private ModelAndView view = new ModelAndView();
	
	/**
	 * 用户登录
	 * @param request
	 * @return 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User user, @RequestHeader HttpHeaders headers) throws Exception {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^request: 登录" + Json.toJson(headers));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^request: 登录" + Json.toJson(user));
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		User partUser = null;
		//try catch 用于处理未知异常
		try {
			partUser = userService.login(user.getUserName(), user.getPassword());
		} catch (Exception e) {
			System.out.println("ttm | error");
			throw new Exception("查询出现异常");
		}
		
		if (partUser == null) {
			partResponseBase = userService.constructFindNoInfoError();
		} else {
			partResponseBase = userService.constructResultLogin(partUser);
		}
		return Json.toJson(partResponseBase);
	} 
	
	/**
	 * 注册接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User user, @RequestHeader HttpHeaders header) {
		String userName = user.getUserName();
		String password = user.getPassword();
		String code = "test";
		// 校验验证码
		if (!"success".equals(UserUtil.checkCode(code))) {
			return Json.toJson(userService.constructCheckCodeError());
		}
		User userNew = userService.register(userName, password);
		
		return Json.toJson(userService.constructResultRegister(userNew));
	}
	
	/**
	 * 注销
	 * @param id
	 * @param headers
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public String logout(@RequestBody Map<String, Object> request, @RequestHeader HttpHeaders headers) throws Exception {
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		String partId = (String) request.get("userId");
		boolean partIsLogout = true;
		try {
			partIsLogout = userService.logout(Integer.valueOf(partId));
		} catch (Exception e) {
			throw new Exception("程序异常...");
		}

		//判断是否存在修改成功
		if (partIsLogout) {
			partResponseBase = userService.constructReturnLogout();
		} else {
			partResponseBase = userService.constructCheckCodeError();
		}
		return Json.toJson(partResponseBase);
	}
	
	/**
	 * 修改个人资料
	 * @param query
	 * @param headers
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public String modifyUserInfo(@RequestBody Map<String, Object> query, @RequestHeader HttpHeaders headers) throws Exception {
		System.out.println("ttm | query --->" + Json.toJson(query));
		ResponseBase<Map<String, Object>> partResponseBase =  new ResponseBase<Map<String, Object>>();
		boolean partIsModifiy = true;
		try {
			partIsModifiy = userService.modifyUserInfo(query);
		} catch (Exception e) {
			throw new Exception("程序出现异常...");
		}
		
		if (partIsModifiy) {
			partResponseBase = userService.constructReturnUserInfo();
		} else {
			partResponseBase = userService.constructCheckCodeError();
		}
		return Json.toJson(partResponseBase);
	}
	
	@RequestMapping(value="myPublished", method=RequestMethod.POST)
	@ResponseBody
	public String myPublished(@RequestBody Map<String, Object> info, @RequestHeader HttpHeaders header){
		String dkToken = null == info.get("token") ? "" : info.get("token").toString();
		String dateTime = null == info.get("dateTime") ? "" : info.get("dateTime").toString();
		int pageNumber = null == info.get("pageNumber") ? 1 : Integer.parseInt(info.get("pageNumber").toString());
		int pageSize = null == info.get("pageSize") ? 1 : Integer.parseInt(info.get("pageSize").toString());
		ResponseBase<Map<String, Object>> response = new ResponseBase<Map<String,Object>>();
		SimpleUser currentUser = userService.myPublished(dkToken);
		if(null == currentUser){
			return Json.toJson(userService.constructFindNoInfoError());
		}
		List<Article> articles = articleService.fetchArticleList(pageNumber, pageSize);
		List<Menu> menus = menuService.fetchMenuList(pageSize, pageNumber);
		
		return Json.toJson(userService.constructReturnMyPublished(currentUser, menus, articles));
	}
	
	/**
	 * 后台登录页面
	 * @return
	 */
	@RequestMapping(value = "/backstage/login", method = RequestMethod.GET)
	public ModelAndView backstageLogin() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^后台登录");
		view.setViewName("/login");
		return view;
	}
	
	/**
	 * 后台登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/backstage/login", method = RequestMethod.POST)
	@ResponseBody
	public String backstageLogin(@RequestParam(value = "account", required = true) String account, @RequestParam(value = "password", required = true) String password) {
		System.out.println("^^^^^^^^^^^^^^^^^^^后台登录");
		System.out.println("account:" + account);
		System.out.println("password:" + password);
		ResponseBase<String> reponse = new ResponseBase<String>();
		reponse.setRe(ResponseRe.RE_SUCCESS);
		reponse.setMsg("SUCCESSS");
		reponse.setData("/v1/user/welcome");
		return Json.toJson(reponse);
	}
	
	/**
	 * 后台欢迎页面
	 * 注意:注意进入这个页面需要登录，零时不加登录验证
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView backstageWelcome() {
		System.out.println("^^^^^^^^^^^^^^^^^^^后台欢迎页面");
		view.setViewName("backstage-container");
		return view;
	}
	
}
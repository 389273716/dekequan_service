package com.dekequan.library.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dekequan.orm.user.AdminUser;

/**
 * 登录用户Session 工具
 * @author 唐太明
 * @date 2016年10月18日 上午5:11:44
 * @version 1.0
 */
public class SessionHelper {

	/**
	 * 系统登录用户名
	 */
	public static final String SESSIONSYSTEMLOGINUSERNAME = "SessionSystemLoginUserName";
	
	/**
	 * 清空session
	 */
	public static final void clearSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute(SessionHelper.SESSIONSYSTEMLOGINUSERNAME);
		
		session.invalidate();
	}

	/**
	 * 返回session中的用户对象
	 * @param request
	 * @return
	 */
	public static final AdminUser getSessionUser(HttpServletRequest request) {
		return (AdminUser) request.getSession().getAttribute(SessionHelper.SESSIONSYSTEMLOGINUSERNAME);
	}
	
}

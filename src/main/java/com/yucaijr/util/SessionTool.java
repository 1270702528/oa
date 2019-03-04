package com.yucaijr.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yucaijr.model.SysUser;

public class SessionTool {

	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	
	public static String getLoginAccout(HttpServletRequest request) {
		return getLoginUser(request).getAccount();
	}
	public static String getLoginNick(HttpServletRequest request) {
		return getLoginUser(request).getName();
	}
	
	public static Object getSessionAttr(HttpServletRequest request,String key) {
		return getSession(request).getAttribute(key);
	}
	
	public static void setSession(HttpServletRequest request,String key,Object o) {
		getSession(request).setAttribute(key, o);
	}
	
	public static void setPermissionSession(HttpServletRequest request,Object o) {
		setSession(request, "permisson", o);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer> getPermissionSession(HttpServletRequest request) {
		return (List<Integer>)getSessionAttr(request, "permisson");
	}
	
	public static SysUser getLoginUser(HttpServletRequest request) {
		return (SysUser) getSessionAttr(request,"user");
	}
	
	public static void setUserSession(HttpServletRequest request,Object o) {
		setSession(request, "user", o);
	}
	
	public static void setRoleSession(HttpServletRequest request,Object o) {
		setSession(request, "roles", o);
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getRoleSession(HttpServletRequest request) {
		return (List<String>)getSessionAttr(request, "roles");
	}	
}

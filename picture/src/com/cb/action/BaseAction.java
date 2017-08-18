package com.cb.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cb.common.Constant;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware , RequestAware , ApplicationAware{
	private static final long serialVersionUID = -4251372217432431454L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, Object> application;
	//扩展ActionSupport状态，增加业务异常
	public static String BUS_EXCEPTION = "busException";
	public Map<String, Object> getSession() {
		return session;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public Map<String, Object> getApplication() {
		return application;
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	/**
	 * 当前登录用户是否是系统管理员
	 */
	public boolean isAdmin() {
		if (session.get(Constant.SESSION_USER) != null && session.get(Constant.SESSION_USER).getClass() == SysAdmin.class) {
			return true;
		} 
		return false;
	}
	public SysUser getCurUser() {
		if (session.get(Constant.SESSION_USER) != null && session.get(Constant.SESSION_USER).getClass() == SysUser.class) {
			return (SysUser) session.get(Constant.SESSION_USER);
		} 
		return null;
	}
	public boolean isLogin() {
		if (session.get(Constant.SESSION_USER) == null) {
			return false;
		}
		return true;
	}
	public Date getCurDate() {
		return new Date();
	}
	public Timestamp getCurTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
}

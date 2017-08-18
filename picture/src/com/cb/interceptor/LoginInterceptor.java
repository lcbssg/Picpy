package com.cb.interceptor;

import com.cb.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 2836124792658120320L;
	public String intercept(ActionInvocation invocation) throws Exception {
		BaseAction baseAction = (BaseAction) invocation.getAction();
		if (baseAction.isAdmin()) {
			return invocation.invoke();
		} else if (baseAction.isLogin()) {//已经登陆的普通用户不能访问如下模块：职业模块（修改、删除、创建），主页图片（创建修改删除）
			String actionName = invocation.getProxy().getActionName();
			String methodName = invocation.getProxy().getMethod();
			if (actionName.equals("jobAction")) {
				if (methodName.equals("save") || methodName.equals("update") || methodName.equals("delete")) {
					return "nolog";
				}
			}
			if (actionName.equals("mainAction")) {
				if (methodName.equals("save") || methodName.equals("delete")) {
					return "nolog";
				}
			}
			return invocation.invoke();
		} else {//没有登陆，只有查看主页、查看各类别作品列表的功能
			String actionName = invocation.getProxy().getActionName();
			String methodName = invocation.getProxy().getMethod();
			if (actionName.equals("mainAction")) {
				if (methodName.equals("findAll") || methodName.equals("findMainContent") || methodName.equals("toMain")) {
					return invocation.invoke();
				} else {
					return "nolog";
				}
			} else if (actionName.equals("jobAction")) {
				if (methodName.equals("findAll") || methodName.equals("findById")) {
					return invocation.invoke();
				} else {
					return "nolog";
				}
			} else if (actionName.equals("loginAction")) {
				if (methodName.equals("login") || methodName.equals("findValidateCode")) {
					return invocation.invoke();
				} else {
					return "nolog";
				}
			} else if (actionName.equals("productAction")) {
				if (methodName.equals("findProductBySortAndPage")) {
					return invocation.invoke();
				} else {
					return "nolog";
				}
			} else if (actionName.equals("userAction")) {
				if (methodName.equals("register")) {
					return invocation.invoke();
				} else {
					return "nolog";
				}
			}else {
				return "toMain";
			}
		}
	}
}

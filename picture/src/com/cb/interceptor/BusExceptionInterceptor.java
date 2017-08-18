package com.cb.interceptor;

import com.cb.action.BaseAction;
import com.cb.common.exception.BusinessException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BusExceptionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -1010368208561521656L;

	public String intercept(ActionInvocation invocation){
		try {
			String ret = invocation.invoke();
			return ret;
		} catch (Exception e) {
			if (e.getClass() == BusinessException.class) {
				BusinessException be = (BusinessException) e;
				BaseAction baseAction = (BaseAction) invocation.getAction();
				baseAction.getRequest().put("message", be.getBusMessage());
				return "busException";
			}
			return null;
		}
	}
}

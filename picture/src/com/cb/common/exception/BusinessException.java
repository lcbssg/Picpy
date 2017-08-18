package com.cb.common.exception;

import org.springframework.core.NestedRuntimeException;

public class BusinessException extends NestedRuntimeException{
		private String busMessage;
	    public String getBusMessage() {
			return busMessage;
		}
		public void setBusMessage(String busMessage) {
			this.busMessage = busMessage;
		}
		private static final long serialVersionUID = 1L;
	    /**
	     * 构造方法
	     * @param message
	     */
	    public BusinessException() {
	        super("出现数据访问错误，请与系统管理员联系");
	        this.busMessage="出现数据访问错误，请与系统管理员联系";
	    }
	    /**
	     * 构造方法
	     * @param message
	     */
	    public BusinessException(String message) {
	        super(message);
	        this.busMessage = message;
	    }
	    /**
	     * 构造方法
	     * @param message
	     * @param cause
	     */
	    public BusinessException(String message, Throwable cause) {
	        super(message, cause);
	        this.busMessage = message;
	    }
}

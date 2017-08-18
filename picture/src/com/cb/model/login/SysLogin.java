package com.cb.model.login;

import java.sql.Timestamp;

import com.cb.model.user.SysUser;

public class SysLogin {
	private int loginId;
	private SysUser sysUser;
	private Timestamp loginTime;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}

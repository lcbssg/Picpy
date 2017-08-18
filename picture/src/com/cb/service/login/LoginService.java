package com.cb.service.login;

import java.util.Date;

import com.cb.model.login.SysLogin;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;

public interface LoginService {
	/**
	 * 根据登录帐号获取用户详细信息
	 * @param pLoginName 登录帐号
	 * @return
	 */
	SysUser findUserByLoginName(String pLoginName);
	/**
	 * 根据登录帐号获取管理员详细信息
	 * @param pLoginName 登录帐号
	 * @return
	 */
	SysAdmin findAdminByLoginName(String pLoginName);
	/**
	 * 保存登录信息
	 * @param pSysLogin
	 * @param pSysUser
	 * @return
	 */
	SysLogin save(SysLogin pSysLogin, SysUser pSysUser);
	/**
	 * 获取某天登录总数
	 * @param date
	 * @return
	 */
	Integer findCountByDate(Date date);
	
}

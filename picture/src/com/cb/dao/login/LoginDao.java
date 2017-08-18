package com.cb.dao.login;

import java.util.Date;

import com.cb.model.login.SysLogin;
import com.cb.model.user.SysUser;

public interface LoginDao {
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

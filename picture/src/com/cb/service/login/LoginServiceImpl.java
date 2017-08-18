package com.cb.service.login;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.login.LoginDao;
import com.cb.dao.user.UserDao;
import com.cb.model.login.SysLogin;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;

public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public SysUser findUserByLoginName(String pLoginName) {
		try {
			return userDao.findUserByLoginName(pLoginName);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new BusinessException("出现系统错误1，请与管理员联系" , e);
		}
	}
	public SysAdmin findAdminByLoginName(String pLoginName) {
		try {
			return userDao.findAdminByLoginName(pLoginName);
		} catch (DataAccessException e) {
			throw new BusinessException("出现系统错误2，请与管理员联系" , e);
		}
	}
	public SysLogin save(SysLogin pSysLogin, SysUser pSysUser) {
		try {
			return loginDao.save(pSysLogin, pSysUser);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new BusinessException("出现系统错误3，请与管理员联系" , e);
		}
	}
	public Integer findCountByDate(Date date) {
		try {
			return loginDao.findCountByDate(date);
		} catch (DataAccessException e) {
			throw new BusinessException("出现系统错误4，请与管理员联系" , e);
		}
	}
}

package com.cb.service.user;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.job.JobDao;
import com.cb.dao.user.UserDao;
import com.cb.model.job.SysJob;
import com.cb.model.login.SysLogin;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;
import com.cb.service.login.LoginService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private LoginService loginService;
	private JobDao jobDao;
	public JobDao getJobDao() {
		return jobDao;
	}
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public SysUser register(SysUser pSysUser) {
		SysUser user = userDao.findUserByLoginName(pSysUser.getLoginName());
		if (user != null) {
			throw new BusinessException("已经有人注册过" + pSysUser.getLoginName() + "的账号");
		}
		SysAdmin admin = userDao.findAdminByLoginName(pSysUser.getLoginName());
		if (admin != null) {
			throw new BusinessException("已经有人注册过" + pSysUser.getLoginName() + "的账号");
		}
		try {
			SysUser su =  userDao.save(pSysUser);
			SysLogin sl = new SysLogin();
			sl.setLoginTime(su.getRegisterTime());
			loginService.save(sl, su);
			return su;
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public List<SysUser> findByPage(int pPage) {
		try {
			return userDao.findByPage(pPage);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public void lockUser(SysUser pSysUser) {
		try {
			pSysUser = userDao.findById(pSysUser.getUserId());
			pSysUser.setIsLock(true);
			userDao.update(pSysUser);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	public void unLockUser(SysUser pSysUser) {
		try {
			pSysUser = userDao.findById(pSysUser.getUserId());
			pSysUser.setIsLock(false);
			userDao.update(pSysUser);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public int findCount() {
		try {
			return userDao.findCount();
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public SysUser findById(int id) {
		try {
			return userDao.findById(id);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public SysUser updatePassword(SysUser pSysUser) {
		return userDao.update(pSysUser);
	}
	public SysUser updateInfor(SysUser pSysUser) {
		try {
			SysJob job = jobDao.findByID(pSysUser.getSysJob().getJobId());
			SysUser su = userDao.findById(pSysUser.getUserId());
			su.setUserName(pSysUser.getUserName());
			su.setBirthday(pSysUser.getBirthday());
			su.setEmail(pSysUser.getEmail());
			su.setIsMale(pSysUser.getIsMale());
			su.setPhoneNum(pSysUser.getPhoneNum());
			su.setSysJob(job);
			return userDao.update(su);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	public void updateImage(SysUser pSysUser,File pImage, String realPath) {
		String oldImageUrl = null;
		try {
			SysUser su = userDao.findById(pSysUser.getUserId());
			if (su.getImageUrl() != null) {
				oldImageUrl = su.getImageUrl();
			} 
			su.setImageUrl(pSysUser.getImageUrl());
			userDao.update(su);
		} catch (DataAccessException e1) {
			throw new BusinessException("出现数据库保存错误，请与系统管理员联系");
		}
		try {
			FileUtils.copyFile(pImage, new File(realPath + pSysUser.getImageUrl()));
			if (oldImageUrl != null) {
				File file = new File(realPath + oldImageUrl);
				//删除文件
				file.delete();
			}
		} catch (IOException e) {
			throw new BusinessException("文件上传错误", e);
		}
	}
}

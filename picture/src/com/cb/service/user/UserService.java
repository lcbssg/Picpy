package com.cb.service.user;

import java.io.File;
import java.util.List;

import com.cb.model.user.SysUser;

public interface UserService {
	/**
	 * 用户注册
	 * @param pSysUser
	 * @return
	 */
	SysUser register(SysUser pSysUser);
	/**
	 * 修改用户密码
	 * @param pSysUser
	 * @return
	 */
	SysUser updatePassword(SysUser pSysUser);
	/**
	 * 修改用户信息
	 * @param pSysUser
	 * @return
	 */
	SysUser updateInfor(SysUser pSysUser);
	/**
	 * 根据页数获取用户信息
	 * @param pPage
	 * @return
	 */
	List<SysUser> findByPage(int pPage);
	/**
	 * 锁定用户
	 * @param pSysUser
	 */
	void lockUser(SysUser pSysUser);
	/**
	 * 解锁用户
	 * @param pSysUser
	 */
	void unLockUser(SysUser pSysUser);
	/**
	 * 获取用户数量
	 * @return
	 */
	int findCount();
	/**根据id获取用户信息
	 */
	SysUser findById(int id);
	/**上传或修改用户相片
	 */
	void updateImage(SysUser pSysUser,File pImage, String pRealPath);
}

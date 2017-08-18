package com.cb.dao.user;

import java.util.List;

import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;

public interface UserDao {
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
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	SysUser findById(int id);
	/**
	 * 修改用户信息
	 * @param pSysAdmin
	 * @return
	 */
	SysUser update(SysUser pSysUser);
	/**
	 * 
	 * @param pSysAdmin
	 * @return
	 */
	SysUser save(SysUser pSysUser);
	/**
	 * 根据页数获取用户信息
	 * @param page
	 * @return
	 */
	List<SysUser> findByPage(int page);
	/**
	 * 获取用户数量
	 * @return
	 */
	int findCount();
	/**
	 * 获取最热门的5个用户，该用户作品的查看量最大
	 * @return
	 */
	List<SysUser> findTopFireUser();
}

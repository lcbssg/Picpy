package com.cb.dao.main;

import java.util.List;

import com.cb.model.main.SysMain;

public interface MainDao {
	/**
	 * 保存主页图片信息
	 * @param pSysMain
	 * @return
	 */
	SysMain save(SysMain pSysMain);
	/**
	 * 删除主页图片信息
	 * @param pSysMain
	 * @return
	 */
	SysMain delete(SysMain pSysMain);
	/**
	 * 查询主页全部图片
	 * @return
	 */
	List<SysMain> findAll();
	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 */
	SysMain findById(int id);
}

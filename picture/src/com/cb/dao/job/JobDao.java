package com.cb.dao.job;

import java.util.List;

import com.cb.model.job.SysJob;

public interface JobDao {
	/**
	 * 获取全部职位信息
	 * @return
	 */
	List<SysJob> findAll();
	/**
	 * 保存职位信息
	 */
	SysJob save(SysJob pSysJob);
	/**
	 * 修改职位信息
	 * @param pSysJob
	 * @return
	 */
	SysJob update(SysJob pSysJob);
	/**
	 * 根据id获取职位信息
	 * @param id
	 * @return
	 */
	SysJob findByID(int id);
	/**
	 * 根据职位名称获取职位对象
	 * @param pJobName
	 * @return
	 */
	SysJob findByName(String pJobName);
	/**
	 * 删除职位信息
	 * @param id
	 * @return
	 */
	void delete(SysJob pSysJob);
	/**
	 * 根据职位id返回是否有用于使用当前职位信息
	 * @param pJobId
	 * @return
	 */
	boolean isHaveUser(int pJobId);
	
}

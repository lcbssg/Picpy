package com.cb.service.job;

import java.util.List;

import com.cb.model.job.SysJob;

public interface JobService {
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
	 * 删除职位信息
	 * @param id
	 * @return
	 */
	void delete(SysJob pSysJob);
}

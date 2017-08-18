package com.cb.service.job;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.job.JobDao;
import com.cb.model.job.SysJob;

public class JobServiceImpl implements JobService{
	private JobDao jobDao;
	
	public JobDao getJobDao() {
		return jobDao;
	}
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	public List<SysJob> findAll() {
		try {
			return jobDao.findAll();
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public SysJob save(SysJob pSysJob) {
		try {
			SysJob sj = jobDao.findByName(pSysJob.getJobName());
			if (sj != null) {
				throw new BusinessException("已经存在" + pSysJob.getJobName() + "的职位名称");
			}
			return jobDao.save(pSysJob);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public SysJob update(SysJob pSysJob) {
		try {
			SysJob sj = jobDao.findByName(pSysJob.getJobName());
			if (sj != null && (sj.getJobId() != pSysJob.getJobId())) {
				throw new BusinessException("已经存在" + pSysJob.getJobName() + "的职位名称");
			}
			return jobDao.update(pSysJob);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public SysJob findByID(int id) {
		try {
			return jobDao.findByID(id);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public void delete(SysJob pSysJob) {
		try {
			if (jobDao.isHaveUser(pSysJob.getJobId())) {
				throw new BusinessException("有其他用户使用该职位，无法删除");
			}
			jobDao.delete(pSysJob);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
}

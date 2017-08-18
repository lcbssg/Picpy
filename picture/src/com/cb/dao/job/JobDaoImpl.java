package com.cb.dao.job;

import java.util.List;

import com.cb.dao.BaseDao;
import com.cb.model.job.SysJob;

public class JobDaoImpl extends BaseDao implements JobDao {

	@SuppressWarnings("unchecked")
	public List<SysJob> findAll() {
		String hql = "from SysJob";
		return getHibernateTemplate().find(hql);
	}

	public SysJob save(SysJob pSysJob) {
		Integer id = (Integer) getHibernateTemplate().save(pSysJob);
		pSysJob.setJobId(id);
		return pSysJob;
	}

	public SysJob update(SysJob pSysJob) {
		getHibernateTemplate().update(pSysJob);
		return pSysJob;
	}

	public SysJob findByID(int id) {
		return getHibernateTemplate().get(SysJob.class, id);
	}

	public SysJob findByName(String pJobName) {
		String hql = "from SysJob where jobName = ?";
		@SuppressWarnings("unchecked")
		List<SysJob> jobs = getHibernateTemplate().find(hql,pJobName);
		return jobs.isEmpty()?null:jobs.get(0);
	}
	public void delete(SysJob pSysJob) {
		getHibernateTemplate().delete(pSysJob);
	}
	public boolean isHaveUser(int pJobId) {
		String hql = "select count(*) from SysUser u where u.sysJob.jobId = " + pJobId;
		int count = Integer.valueOf(getHibernateTemplate().find(hql).iterator().next().toString());
		return count > 0;
	}
}

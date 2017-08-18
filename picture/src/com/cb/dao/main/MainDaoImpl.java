package com.cb.dao.main;

import java.util.List;

import com.cb.dao.BaseDao;
import com.cb.model.main.SysMain;

public class MainDaoImpl extends BaseDao implements MainDao{

	public SysMain save(SysMain pSysMain) {
		Integer id = (Integer) getHibernateTemplate().save(pSysMain);
		pSysMain.setMainId(id);
		return pSysMain;
	}

	public SysMain delete(SysMain pSysMain) {
		getHibernateTemplate().delete(pSysMain);
		return pSysMain;
	}

	@SuppressWarnings("unchecked")
	public List<SysMain> findAll() {
		String hql = "from SysMain";
		return getHibernateTemplate().find(hql);
	}

	public SysMain findById(int id) {
		return getHibernateTemplate().get(SysMain.class, id);
	}
}

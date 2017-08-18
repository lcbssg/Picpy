package com.cb.dao.login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cb.dao.BaseDao;
import com.cb.model.login.SysLogin;
import com.cb.model.user.SysUser;

public class LoginDaoImpl extends BaseDao implements LoginDao {

	public SysLogin save(SysLogin pSysLogin, SysUser pSysUser) {
		//只设定单向关联关系，避免双向关系要获取当前用户全部登录信息
		pSysLogin.setSysUser(pSysUser);
		int id = (Integer) getHibernateTemplate().save(pSysLogin);
		pSysLogin.setLoginId(id);
		return pSysLogin;
	}
	public Integer findCountByDate(Date date) {
		String hql = "select count(*) from SysLogin where date_format(loginTime,'%Y-%m-%d') = ?";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("rawtypes")
		List ret = getHibernateTemplate().find(hql, df.format(date));
		if (ret == null) {
			return 0;
		} else {
			return Integer.valueOf(ret.listIterator().next().toString());
		}
	}
}

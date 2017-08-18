package com.cb.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cb.common.Constant;
import com.cb.dao.BaseDao;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;

public class UserDaoImpl extends BaseDao implements UserDao{

	@SuppressWarnings("unchecked")
	public SysUser findUserByLoginName(String pLoginName) {
		String hql = "from SysUser as u where u.loginName = ?";
		List<SysUser> users = getHibernateTemplate().find(hql, pLoginName);
		return users.isEmpty()?null:users.get(0);
	}

	@SuppressWarnings("unchecked")
	public SysAdmin findAdminByLoginName(String pLoginName) {
		String hql = "from SysAdmin as u where u.loginName = ?";
		List<SysAdmin> admins = getHibernateTemplate().find(hql, pLoginName);
		return admins.isEmpty()?null:admins.get(0);
	}

	public SysUser findById(int id) {
		return getHibernateTemplate().get(SysUser.class, id);
	}

	public SysUser update(SysUser pSysUser) {
		getHibernateTemplate().update(pSysUser);
		return pSysUser;
	}

	public SysUser save(SysUser pSysUser) {
		Integer id = (Integer) getHibernateTemplate().save(pSysUser);
		pSysUser.setUserId(id);
		return pSysUser;
	}

	@SuppressWarnings("unchecked")
	public List<SysUser> findByPage(final int page) {
		final String hql = "from SysUser u left outer join fetch u.sysJob";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<SysUser>>() {
			public List<SysUser> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setFirstResult((page - 1) * Constant.USER_NUMBER_PAGE); 
				query.setMaxResults(Constant.USER_NUMBER_PAGE); 
				List<SysUser> list = query.list(); 
				return list; 
			}
		});
	}

	public int findCount() {
		String hql = "select count(*) from SysUser";
		return Integer.valueOf(getHibernateTemplate().find(hql).iterator().next().toString()) ;
	}
	@SuppressWarnings("unchecked")
	public List<SysUser> findTopFireUser() {
		final String sql = "select u.user_id,count(q.product_query_id) as q " +
				"from sys_user u left join product p " +
				"on u.user_id = p.create_user " +
				"and u.is_lock = 'n' "+
				"left join product_query q " +
				"on p.product_id = q.product_id  "+
				"group by u.user_id order by q desc";
		List<Object[]> userIds =  getHibernateTemplate().executeFind(new HibernateCallback<List<Object[]>>() {
			public List<Object[]> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql); 
				query.setFirstResult(0); 
				query.setMaxResults(5); 
				List<Object[]> list = query.list(); 
				return list; 
			}
		});
		if (userIds.isEmpty()) {
			return new ArrayList<SysUser>();
		}
		StringBuffer hql = new StringBuffer(" from SysUser u inner join fetch u.sysJob where u.userId in(");
		for(int i = 0 ; i < userIds.size();i++) {
			hql.append(userIds.get(i)[0]).append(",");
		}
		hql.deleteCharAt(hql.length() - 1);
		hql.append(")");
		return getHibernateTemplate().find(hql.toString());
	}
}

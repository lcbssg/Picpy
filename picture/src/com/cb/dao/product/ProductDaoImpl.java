package com.cb.dao.product;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cb.common.Constant;
import com.cb.dao.BaseDao;
import com.cb.model.product.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{
	
	public Product findById(int id) {
		return getHibernateTemplate().get(Product.class, id);
	}
	/**
	 * 可以在product.hbmx.xml中加入fetch=join代替如下功能，
	 * 但为了保证不影响其他模块查询的性能，应避免使用hibernate的关联的功能，尽量用hql解决
	 *  <!-- 与用户关联 -->
        <many-to-one name="sysUser" fetch="join" class="com.chinasofti.model.user.SysUser" column="CREATE_USER" >
        </many-to-one>
	 */
	public Product findDetailById(int id) {
		String hql = "from Product p inner join fetch p.sysUser u" +
				" inner join fetch p.productSort s" +
				" inner join fetch u.sysJob where p.productId = ?";
		try {
			return (Product) getHibernateTemplate().find(hql, id).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product save(Product pProduct) {
		Integer id = (Integer) getHibernateTemplate().save(pProduct);
		pProduct.setProductId(id);
		return pProduct;
	}

	public Product update(Product pProduct) {
		getHibernateTemplate().update(pProduct);
		return pProduct;
	}
	public void delete(Product pProduct) {
		getHibernateTemplate().delete(pProduct);

	}
	@SuppressWarnings("unchecked")
	public List<Product> findByUserAndPage(final int pUserId, final int page) {
		final String hql = "from Product p inner join fetch " +
				"p.productSort s " +
				"inner join fetch p.sysUser u " +
				"where u.userId = ? " +
				"and u.isLock = false " +
				"order by p.productId desc";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setInteger(0, pUserId);
				query.setFirstResult((page - 1) * Constant.PRODUCT_NUMBER_PAGE); 
				query.setMaxResults(Constant.PRODUCT_NUMBER_PAGE); 
				List<Product> list = query.list(); 
				return list; 
			}
		});
	}
	@SuppressWarnings("unchecked")
	public List<Product> findBySortAndPage(final int pSortId, final int page) {
		final String hql = "from Product p " +
				"inner join fetch p.productSort s " +
				"inner join fetch p.sysUser u " +
				"where u.isLock = false " +
				"and  p.productSort.sortId = ? " +
				"order by p.productId desc";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setInteger(0, pSortId);
				query.setFirstResult((page - 1) * Constant.PRODUCT_NUMBER_PAGE); 
				query.setMaxResults(Constant.PRODUCT_NUMBER_PAGE); 
				List<Product> list = query.list(); 
				return list; 
			}
		});
	}
	public int findProductCountBySort(int sortId) {
		String hql = "select count(*) from Product  where sysUser.isLock = false and productSort.sortId = ?";
		return Integer.valueOf(getHibernateTemplate().find(hql,sortId).iterator().next().toString()) ;
	}
	public int findProductCountByUser(int pUserId) {
		String hql = "select count(*) from Product where sysUser.isLock = false and sysUser.userId = ?";
		return Integer.valueOf(getHibernateTemplate().find(hql,pUserId).iterator().next().toString()) ;
	}
	@SuppressWarnings("unchecked")
	public List<Product> findThreeProductBySort(final int sortId) {
		final String hql = "from Product p " +
				" left outer join fetch" +
				" p.productSort s " +
				" left outer join fetch " +
				" p.sysUser u " +
				" where u.isLock = false and s.sortId = ? order by p.productId desc";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, sortId);
				query.setMaxResults(3);
				query.setFirstResult(0);
				return query.list();
			}
		});
	}
}

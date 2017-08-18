package com.cb.dao.comment;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cb.common.Constant;
import com.cb.dao.BaseDao;
import com.cb.model.comment.ProductComment;

public class CommentDaoImpl extends BaseDao implements CommentDao {

	public ProductComment save(ProductComment pProductComment) {
		Integer id = (Integer) getHibernateTemplate().save(pProductComment);
		pProductComment.setCommentId(id);
		return pProductComment;
	}

	public ProductComment update(ProductComment pProductComment) {
		getHibernateTemplate().update(pProductComment);
		return pProductComment;
	}

	public void delete(ProductComment pProductComment) {
		getHibernateTemplate().delete(pProductComment);
	}

	public ProductComment findById(int id) {
		return getHibernateTemplate().get(ProductComment.class, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findCommentAndReplyByProId(List<Integer> pCommentIds) {
		if (pCommentIds.isEmpty()) {
			return null;
		}
		final StringBuffer hql = new StringBuffer("select distinct c from ProductComment c " +
				" left outer join fetch " +
				" c.commentReplies r " +
				"left outer join fetch " +
				"c.sysUser " +
				"left outer  join fetch" +
				" r.sysUser " +
				"where c.commentId in (");
		for (int i = 0 ;i < pCommentIds.size();i++) {
			hql.append(pCommentIds.get(i).toString() + ",");
		}
		hql.deleteCharAt(hql.length()-1);
		hql.append(") order by c.commentId desc");
		return getHibernateTemplate().find(hql.toString());
	}

	public int findCommentCountByProduct(int pProductId) {
		String hql = "select count(*) from ProductComment c where c.sysUser.isLock = false and c.product.productId = ?";
		return Integer.valueOf(getHibernateTemplate().find(hql,pProductId).iterator().next().toString()) ;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> findCommentIdsByProduct(final int pProductId, final int pPage) {
		final String hql = "select commentId from ProductComment c where c.sysUser.isLock = false and c.product.productId = ? order by commentId desc";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Integer>>() {
			public List<Integer> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, pProductId);
				query.setFirstResult((pPage - 1) * Constant.COMMENT_NUMBER_PAGE); 
				query.setMaxResults(Constant.COMMENT_NUMBER_PAGE); 
				List<Integer> list = query.list(); 
				return list; 
			}
		});
	}
	@SuppressWarnings("unchecked")
	public List<ProductComment> findLastFiveComment() {
		final String hql = " from ProductComment c" +
				" inner join fetch c.sysUser " +
				" inner join fetch c.product"+
				" where c.sysUser.isLock = false"+
				" order by c.commentId desc";
		return getHibernateTemplate().executeFind(new HibernateCallback<List<ProductComment>>() {
			public List<ProductComment> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(0); 
				query.setMaxResults(5); 
				List<ProductComment> list = query.list(); 
				return list; 
			}
		});
	}
}

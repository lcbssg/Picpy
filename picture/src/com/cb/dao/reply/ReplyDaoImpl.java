package com.cb.dao.reply;

import java.util.List;

import com.cb.dao.BaseDao;
import com.cb.model.reply.CommentReply;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {

	public CommentReply save(CommentReply pCommentReply) {
		Integer id = (Integer) getHibernateTemplate().save(pCommentReply);
		pCommentReply.setReplyId(id);
		return pCommentReply;
	}
	public CommentReply update(CommentReply pCommentReply) {
		getHibernateTemplate().update(pCommentReply);
		return pCommentReply;
	}
	public void delete(CommentReply pCommentReply) {
		getHibernateTemplate().delete(pCommentReply);
	}

	public CommentReply findById(int id) {
		String hql = "from CommentReply c" +
				" inner join fetch " +
				" c.productComment pc " +
				" inner join fetch " +
				" pc.product " +
				" where c.replyId=? ";
		@SuppressWarnings("unchecked")
		List<CommentReply> list = getHibernateTemplate().find(hql,id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}

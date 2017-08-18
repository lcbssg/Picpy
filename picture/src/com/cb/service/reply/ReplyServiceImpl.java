package com.cb.service.reply;


import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.reply.ReplyDao;
import com.cb.model.reply.CommentReply;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDao replyDao;
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public CommentReply save(CommentReply pCommentReply) {
		try {
			return replyDao.save(pCommentReply);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	
	public void delete(CommentReply pCommentReply) {
		try {
			replyDao.delete(pCommentReply);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public CommentReply update(CommentReply pCommentReply) {
		try {
			CommentReply reply = findById(pCommentReply.getReplyId());
			reply.setReplyContent(pCommentReply.getReplyContent());
			return replyDao.update(reply);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public CommentReply findById(int id) {
		try {
			return replyDao.findById(id);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
}

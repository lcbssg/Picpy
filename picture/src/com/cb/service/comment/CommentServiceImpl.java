package com.cb.service.comment;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.comment.CommentDao;
import com.cb.model.comment.ProductComment;

public class CommentServiceImpl implements CommentService {
	private CommentDao commentDao;
	
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public ProductComment save(ProductComment pProductComment) {
		try {
			return commentDao.save(pProductComment);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public ProductComment update(ProductComment pProductComment) {
		try {
			ProductComment comment = commentDao.findById(pProductComment
					.getCommentId());
			comment.setCommentContent(pProductComment.getCommentContent());
			return commentDao.update(comment);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public void delete(ProductComment pProductComment) {
		try {
			commentDao.delete(pProductComment);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public ProductComment findById(int id) {
		try {
			return commentDao.findById(id);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public List<ProductComment> findCommentAndReplyByProId(int pProductId, int page) {
		try {
			List<Integer> commentIds = commentDao.findCommentIdsByProduct(pProductId, page);
			return commentDao.findCommentAndReplyByProId(commentIds);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public int findCommentCountByProduct(int pProductId) {
		try {
			return commentDao.findCommentCountByProduct(pProductId);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
}

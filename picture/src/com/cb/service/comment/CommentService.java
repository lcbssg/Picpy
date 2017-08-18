package com.cb.service.comment;

import java.util.List;

import com.cb.model.comment.ProductComment;

public interface CommentService {
	/**
	 * 保存评论信息
	 * @param pProductComment
	 * @return
	 */
	ProductComment save(ProductComment pProductComment);
	/**
	 * 修改评论信息
	 * @param pProductComment
	 * @return
	 */
	ProductComment update(ProductComment pProductComment);
	/**
	 * 删除评论信息
	 * @param pProductComment
	 */
	void delete(ProductComment pProductComment);
	
	/**
	 * 根据id获取评论
	 * @param id
	 * @return
	 */
	ProductComment findById(int id);
	/**
	 * 获取作品的评论、评论者以及回复、回复者信息（按照评论分页显示）
	 * @return
	 */
	List<ProductComment> findCommentAndReplyByProId(int pProductId,int page);
	/**
	 * 获取某一个作品的评论数量
	 * @param pProductId
	 * @return
	 */
	int findCommentCountByProduct(int pProductId);
	
}

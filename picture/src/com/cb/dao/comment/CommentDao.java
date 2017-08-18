package com.cb.dao.comment;

import java.util.List;

import com.cb.model.comment.ProductComment;

public interface CommentDao {
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
	 * 根据评论的id集合获取作品的评论、评论者以及回复、回复者信息，并封装到productComment对象中
	 * @return
	 */
	List<ProductComment> findCommentAndReplyByProId(List<Integer> pCommentIds);
	/**
	 * 获取某一个作品的评论数量
	 * @param pProductId
	 * @return
	 */
	int findCommentCountByProduct(int pProductId);
	/**
	 * 获取某一个作品的评论id，分页获取
	 * @param pProductId
	 * @param pPage
	 * @return
	 */
	List<Integer> findCommentIdsByProduct(int pProductId , int pPage);
	
	/**
	 * 获取最新5条评论、评论者、评论对应的作品
	 * @return
	 */
	public List<ProductComment> findLastFiveComment();
}

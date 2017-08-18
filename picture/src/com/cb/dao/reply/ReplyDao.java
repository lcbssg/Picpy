package com.cb.dao.reply;

import com.cb.model.reply.CommentReply;

public interface ReplyDao {
	/**
	 * 保存回复信息
	 * @param pCommentReply
	 * @return
	 */
	CommentReply save(CommentReply pCommentReply);
	/**
	 * 修改回复信息
	 * @param pCommentReply
	 * @return
	 */
	CommentReply update(CommentReply pCommentReply);
	/**
	 * 删除回复信息
	 * @param pCommentReply
	 */
	void delete(CommentReply pCommentReply);
	
	/**
	 * 根据id获取回复
	 * @param id
	 * @return
	 */
	CommentReply findById(int id);
}

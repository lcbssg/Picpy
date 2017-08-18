package com.cb.service.main;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cb.model.comment.ProductComment;
import com.cb.model.main.SysMain;
import com.cb.model.product.Product;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;

public interface MainService {
	/**
	 * 保存主页图片信息
	 * @param pSysMain
	 * @param pImage 图片文件
	 * @param url 图片要被保存的地址
	 * @return
	 */
	SysMain save(SysMain pSysMain,File pImage, String url);
	/**
	 * 删除主页图片信息
	 * @param pSysMain
	 * @param pUrl
	 * @return
	 */
	SysMain delete(SysMain pSysMain, String pUrl);
	/**
	 * 查询主页全部图片
	 * @return
	 */
	List<SysMain> findAll();
	/**
	 * 获取每个类别下，最新上传的三个作品
	 * @return
	 */
	Map<ProductSort, List<Product>> findThreeProductBySort();
	/**
	 * 获取最新5条评论信息
	 * @return
	 */
	List<ProductComment> findLastFiveComment();
	/**
	 * 获取最热门的5个设计师（按照作品查询数量）
	 * @return
	 */
	List<SysUser> findTopFireUser();
	/**
	 * 获取某日的登陆数量
	 * @param date
	 * @return
	 */
	Integer findCountByDate(Date date);
}

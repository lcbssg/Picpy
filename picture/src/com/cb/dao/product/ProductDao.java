package com.cb.dao.product;

import java.util.List;

import com.cb.model.product.Product;

public interface ProductDao {
	/**
	 * 根据id获取product对象
	 * @param id
	 * @return
	 */
	Product findById(int id);
	/**
	 * 根据id获取作品对象、关联的作品用户信息，使用非延迟加载
	 * @param id
	 * @return
	 */
	Product findDetailById(int id);
	/**
	 * 保存作品
	 * @param pProduct
	 * @return
	 */
	Product save(Product pProduct);
	/**
	 * 修改作品对象
	 * @param pProduct
	 * @return
	 */
	Product update(Product pProduct);
	/**
	 * 删除作品对象，级联删除相关的评论、回复、查询数据
	 * @param pProduct
	 */
	void delete(Product pProduct);
	/**
	 * 获取用户的全部作品（分页）
	 * @param pUserId
	 * @param page
	 * @return
	 */
	List<Product> findByUserAndPage(int pUserId, int page);
	/**
	 * 根据分类获取全部作品（分页）
	 * @param pSortId
	 * @param page
	 * @return
	 */
	List<Product> findBySortAndPage(int pSortId, int page);
	/**
	 * 获取某分类的作品数量
	 * @param sortId
	 * @return
	 */
	int findProductCountBySort(int sortId);
	/**
	 * 获取某用户的作品数量
	 * @param sortId
	 * @return
	 */
	int findProductCountByUser(int pUserId);
	/**
	 * 获取每个类别下，最新上传的三个作品
	 * @return
	 */
	List<Product> findThreeProductBySort(int pSortId);
}

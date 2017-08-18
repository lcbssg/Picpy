package com.cb.service.product;

import java.io.File;
import java.util.List;

import com.cb.model.product.Product;
import com.cb.model.product.ProductSort;

public interface ProductService {
	/**
	 * 保存作品信息
	 * @param pProduct
	 * @param pImageFile
	 * @param pRealPath
	 * @return
	 */
	Product save(Product pProduct , File pImageFile , String pRealPath);
	/**
	 * 保存作品信息
	 * @param pProduct
	 * @param pImageFile
	 * @param pRealPath
	 * @return
	 */
	Product update(Product pProduct , File pImageFile , String pRealPath);
	/**
	 * 删除作品信息
	 * @param pProduct
	 * @param pImageFile
	 * @param pRealPath
	 * @return
	 */
	void delete(Product pProduct);
	/**
	 * 根据id获取作品信息
	 * @param id
	 * @return
	 */
	Product findById(int id);
	/**
	 * 根据作品id获取作品、该作品评论、回复信息
	 * @param id
	 * @param queryUserId
	 * @return 封装好评论、回复信息的product对象
	 */
	Product findProductDetailById(int id, int queryUserId);
	/**
	 * 根据分类获取作品（分页）
	 * @param pUser
	 * @return
	 */
	List<Product> findProductBySortAndPage(int pSortId,int page);
	/**
	 * 
	 * @param pUser
	 * @return
	 */
	List<Product> findProductByUserAndPage(int pUserId,int page);
	/**
	 * 获取全部作品分类
	 * @return
	 */
	List<ProductSort> findAllSort();
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
}

package com.cb.dao.product;

import java.util.List;

import com.cb.model.product.ProductSort;

public interface ProductSortDao {
	

	/**
	 * 获取全部分类
	 * @return
	 */
	List<ProductSort> findAll();
	/**
	 * 根据id获取作品大类
	 * @param id
	 * @return
	 */
	ProductSort findById(int id);
}

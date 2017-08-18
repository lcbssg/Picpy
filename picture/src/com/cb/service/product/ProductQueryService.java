package com.cb.service.product;

import com.cb.model.product.ProductQuery;

public interface ProductQueryService {
	/**
	 * 保存作品查询记录
	 * @param pQuery
	 * @return
	 */
	ProductQuery save(ProductQuery pQuery);
}

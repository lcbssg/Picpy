package com.cb.service.product;

import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.product.ProductQueryDao;
import com.cb.model.product.ProductQuery;

public class ProductQueryServiceImpl implements ProductQueryService {
	private ProductQueryDao productQueryDao;  
	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}
	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}
	
	public ProductQuery save(ProductQuery pQuery) {
		try {
			return productQueryDao.save(pQuery);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
}

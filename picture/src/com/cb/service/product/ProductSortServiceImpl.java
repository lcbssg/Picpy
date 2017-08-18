package com.cb.service.product;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.product.ProductSortDao;
import com.cb.model.product.ProductSort;

public class ProductSortServiceImpl implements ProductSortService {
	private ProductSortDao productSortDao;

	public ProductSortDao getProductSortDao() {
		return productSortDao;
	}
	public void setProductSortDao(ProductSortDao productSortDao) {
		this.productSortDao = productSortDao;
	}
	
	public List<ProductSort> findAll() {
		try {
			return productSortDao.findAll();
		} catch (DataAccessException e) {
			throw new BusinessException("出现系统异常，请与系统管理员联系");
		}
	}
	public ProductSort findById(int id) {
		try {
			return productSortDao.findById(id);
		} catch (DataAccessException e) {
			throw new BusinessException("出现系统异常，请与系统管理员联系");
		}
	}
}

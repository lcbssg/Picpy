package com.cb.dao.product;

import java.util.List;

import com.cb.dao.BaseDao;
import com.cb.model.product.ProductSort;

public class ProductSortDaoImpl extends BaseDao implements ProductSortDao {

	@SuppressWarnings("unchecked")
	public List<ProductSort> findAll() {
		String hql = "from ProductSort";
		return getHibernateTemplate().find(hql);
	}
	public ProductSort findById(int id) {
		return getHibernateTemplate().get(ProductSort.class, id);
	}
}

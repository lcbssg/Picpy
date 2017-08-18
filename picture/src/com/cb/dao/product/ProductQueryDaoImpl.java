package com.cb.dao.product;

import com.cb.dao.BaseDao;
import com.cb.model.product.ProductQuery;

public class ProductQueryDaoImpl extends BaseDao implements ProductQueryDao {

	public ProductQuery save(ProductQuery pQuery) {
		Integer id = (Integer) getHibernateTemplate().save(pQuery);
		pQuery.setProductQueryId(id);
		return pQuery;
	}
}

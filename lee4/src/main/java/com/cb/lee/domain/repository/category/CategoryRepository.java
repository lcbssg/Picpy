package com.cb.lee.domain.repository.category;

import java.util.List;

import com.cb.lee.domain.model.Category;
/**获得单个品种对象或获得所有品种*/
public interface CategoryRepository {
	//从category表获取所有元组
    List<Category> getCategoryList();
    //通过物种名从category表获取一行元组
    Category getCategory(String categoryId);
}

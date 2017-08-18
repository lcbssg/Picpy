package com.cb.lee.domain.service.catalog;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cb.lee.domain.model.Category;
import com.cb.lee.domain.model.Flower;
import com.cb.lee.domain.model.Item;
import com.cb.lee.domain.model.Product;
import com.cb.lee.domain.repository.category.CategoryRepository;
import com.cb.lee.domain.repository.flower.FlowerRepository;
import com.cb.lee.domain.repository.item.ItemRepository;
import com.cb.lee.domain.repository.product.ProductRepository;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private ProductRepository productRepository;
    
    @Inject
    private FlowerRepository flowerRepository;

    
    @Override
    //获取所有物种
    public List<Category> getCategoryList() {
        return categoryRepository.getCategoryList();
    }

    @Override
    //通过物种ID获取物种
    public Category getCategory(String categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    @Override
    //通过产品ID获得产品
    public Product getProduct(String productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    //通过物种ID获得该物种所有产品
    public List<Product> getProductListByCategory(String categoryId) {
        return productRepository.getProductListByCategory(categoryId);
    }

    @Override
    //通过关键词查找所有相关产品
    public List<Product> searchProductList(String keyword) {
        return productRepository.searchProductList("%" + keyword.toLowerCase()
                + "%");
    }

    @Override
    //通过产品ID获得单件列表
    public List<Item> getItemListByProduct(String productId) {
        return itemRepository.getItemListByProduct(productId);
    }

    @Override
    //通过ItemID获得Item
    public Item getItem(String itemId) {
        return itemRepository.getItem(itemId);
    }

    @Override
    /** 判断花是否有货*/
    public boolean isFlowerInStock(int flowerId) {
        return flowerRepository.getInventoryQuantity(flowerId) > 0;
    }
    //-------------------------------更改
	@Override
	public List<Flower> getFlowerListByName(String flowerName) {
		return flowerRepository.getFlowerListByName(flowerName);
	}

	@Override
	public Flower getFlowerDetails(String flowerName, String color) {
		return flowerRepository.getFlowerDetails(flowerName, color);
	}

	@Override
	public List<Flower> searchFlowerList(String keyword) {
		return flowerRepository.searchFlowerList("%" + keyword.toLowerCase()
        + "%");
	}

	@Override
	public Flower getFlowerByFlowerId(int flowerId) {
		return flowerRepository.getFlowerByFlowerId(flowerId);
	}
}

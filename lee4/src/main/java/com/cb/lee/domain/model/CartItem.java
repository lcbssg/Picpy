package com.cb.lee.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**对应购物车单行*/
public class CartItem implements Serializable {

    private static final long serialVersionUID = 6620528781626504362L;

    private Flower flower;
	private int quantity;
    private boolean inStock;
    private BigDecimal total;

    public boolean isInStock() {
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Flower getFlower() {
		return flower;
	}
	public void setFlower(Flower flower) {
		this.flower = flower;
	}

    public int getQuantity() {
        return quantity;
    }
    //数量变化后价格小计
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }
    //数量增加后价格小计
    public void incrementQuantity() {
        quantity++;
        calculateTotal();
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    //商品多个数量的价格小计
    private void calculateTotal() {
        if (flower != null && flower.getListPrice() != null) {
            total = flower.getListPrice().multiply(new BigDecimal(quantity));
        } else {
            total = null;
        }
    }
}

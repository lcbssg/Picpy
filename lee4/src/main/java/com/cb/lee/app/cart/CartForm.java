package com.cb.lee.app.cart;

import java.util.Map;

public class CartForm {
    private Map<Integer, Integer> quantity;//商品和数量键值对

    public void setQuantity(Map<Integer, Integer> quantity) {
        this.quantity = quantity;
    }

    public Map<Integer, Integer> getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartForm [quantity=" + quantity + "]";
    }
}

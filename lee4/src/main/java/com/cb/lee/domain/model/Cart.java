package com.cb.lee.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {

    private static final long serialVersionUID = 8329559983943337176L;

    //key-flowerId。value-CartItem
    private final Map<Integer, CartItem> flowerMap = Collections
            .synchronizedMap(new HashMap<Integer, CartItem>());

    private final List<CartItem> itemList = new ArrayList<CartItem>();

    //获取遍历购物车行的迭代器
    public Iterator<CartItem> getCartItems() {
        return itemList.iterator();
    }
    public Iterator<CartItem> getAllCartItems() {
        return itemList.iterator();
    }
    //获取购物车所有行
    public List<CartItem> getCartItemList() {
        return itemList;
    }
    //返回购物车中商品数目
    public int getNumberOfItems() {
        return itemList.size();
    }
    
    //判断购物车是否包含该商品
    public boolean containsFlowerId(int flowerId) {
        return flowerMap.containsKey(flowerId);
    }
    
    //向购物车增加商品
    public void addFlower(Flower flower, boolean isInStock) {
        CartItem cartItem = (CartItem) flowerMap.get(flower.getFlowerId());
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setFlower(flower);
            cartItem.setQuantity(0);
            cartItem.setInStock(isInStock);
            flowerMap.put(flower.getFlowerId(), cartItem);
            itemList.add(cartItem);
        }
        cartItem.incrementQuantity();
    }
    //减少购物车商品一件
    public Flower removeFlowerById(int flowerId) {
        CartItem cartItem = (CartItem) flowerMap.remove(flowerId);
        if (cartItem == null) {
            return null;
        } else {
            itemList.remove(cartItem);
            return cartItem.getFlower();
        }
    }
    //增加购物车商品一件
    public void incrementQuantityByFlowerId(int flowerId) {
        CartItem cartItem = (CartItem) flowerMap.get(flowerId);
        cartItem.incrementQuantity();
    }
    //设置购物车中商品数量
    public void setQuantityByFlowerId(int flowerId, int quantity) {
        CartItem cartItem = (CartItem) flowerMap.get(flowerId);
        cartItem.setQuantity(quantity);
    }
    //获取购物车总价
    public BigDecimal getSubTotal() {
        BigDecimal subTotal = new BigDecimal("0");
        Iterator<CartItem> items = getAllCartItems();
        while (items.hasNext()) {
            CartItem cartItem = (CartItem) items.next();
            Flower flower = cartItem.getFlower();
            BigDecimal listPrice = flower.getListPrice();
            BigDecimal quantity = new BigDecimal(String.valueOf(cartItem
                    .getQuantity()));
            subTotal = subTotal.add(listPrice.multiply(quantity));
        }
        return subTotal;
    }
}

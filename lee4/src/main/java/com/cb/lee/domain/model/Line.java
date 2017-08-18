package com.cb.lee.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**对应Lineitem表，可以计算订单中单件的总价和所有商品的总价*/
public class Line implements Serializable {

    private static final long serialVersionUID = 6804536240033522156L;

    private int orderId;
    private int lineNumber;
    private int quantity;
	private int flowerId;
    private BigDecimal unitPrice;
    private Flower flower;
    private BigDecimal total;

    public Line() {
    }

    public Line(int lineNumber, CartItem cartItem) {
        this.lineNumber = lineNumber;
        this.quantity = cartItem.getQuantity();
        this.flowerId = cartItem.getFlower().getFlowerId();
        this.unitPrice = cartItem.getFlower().getListPrice();
        this.flower = cartItem.getFlower();
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getLineNumber() {
        return lineNumber;
    }
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitprice) {
        this.unitPrice = unitprice;
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

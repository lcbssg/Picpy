package com.cb.lee.app.cart;

import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cb.lee.domain.model.Cart;
import com.cb.lee.domain.model.CartItem;
import com.cb.lee.domain.model.Flower;
import com.cb.lee.domain.model.Item;
import com.cb.lee.domain.service.catalog.CatalogService;

@Controller
@RequestMapping("cart")
public class CartController {
    @Inject
    protected CatalogService catalogService;
    @Inject
    protected Cart cart;

    @ModelAttribute
    public CartForm setUpForm() {
        return new CartForm();
    }
    @ModelAttribute
    //不加会抛出Neither BindingResult nor plain target object for bean name 'cartForm' available as request attribute
    public Cart getCart() {
        return cart;
    }

    @RequestMapping("viewCart")
    //查看购物车
    public String viewCart() {
        return "cart/Cart";
    }

    @RequestMapping("addFlowerToCart")
    //加入购物车；如果购物车没有该商品，加入；如果有，数量加1
    public String addItemToCart(
            @RequestParam("flowerId") int flowerId) {
    	if (cart.containsFlowerId(flowerId)) {
            cart.incrementQuantityByFlowerId(flowerId);
        } else {
            // 是否有货是一个 必须被更新的实时属性，其它的可以缓存
            boolean isInStock = catalogService.isFlowerInStock(flowerId);
            Flower flower = catalogService.getFlowerByFlowerId(flowerId);
            cart.addFlower(flower, isInStock);
        }
        return "redirect:/cart/viewCart";
    }

    @RequestMapping("updateCartQuantities")
    //增加商品数量，单加的+按钮\多加的输入数字
    public String updateCartQuantities(CartForm cartForm, Model model) {
    	Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            int flowerId = cartItem.getFlower().getFlowerId();
            try {
                int quantity = cartForm.getQuantity().get(flowerId);
                cart.setQuantityByFlowerId(flowerId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                //故意不分析异常
            }
        }
        return "redirect:/cart/viewCart";
    }

    @RequestMapping("removeFlowerFromCart")
    //从购物车移除商品
    public String removeFlowerFromCart(@RequestParam("flowerId") int flowerId) {
        cart.removeFlowerById(flowerId);
        return "redirect:/cart/viewCart";
    }
}

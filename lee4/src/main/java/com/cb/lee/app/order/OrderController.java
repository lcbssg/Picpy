package com.cb.lee.app.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.Cart;
import com.cb.lee.domain.model.Order;
import com.cb.lee.domain.model.UserDetails;
import com.cb.lee.domain.service.order.OrderService;

@Controller
@RequestMapping("order")
@SessionAttributes("scopedTarget.cart")
public class OrderController {

    private static final List<String> CARD_TYPE_LIST;

    @Inject
    protected OrderService orderService;
    @Inject
    protected Mapper beanMapper;
    @Inject
    protected Cart cart;
    
    //初始化卡的类型，不过被我删了
    static {
        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        CARD_TYPE_LIST = Collections.unmodifiableList(cardList);
    }
    @ModelAttribute("creditCardTypes")
    public List<String> getCardTypeList() {
        return CARD_TYPE_LIST;
    }
    
    @RequestMapping("newOrderForm")
    //购物车确认后要填写收货地址的表单
    public String newOrderForm(OrderForm orderForm, Model model) {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails)obj;
            Account account = userDetails.getAccount();
            Order order = new Order();
            order.initOrder(account, cart);
            beanMapper.map(order, orderForm);
            model.addAttribute(order);
    	}
        return "order/NewOrderForm";
    }

    @RequestMapping(value = "newOrder")
    //填完收货信息表单后转到确认信息页面，不需要checkbox了
    public String confirmOrder(OrderForm orderForm, Order order) {
        return "order/ConfirmOrder";
    }

    @RequestMapping(value = "newOrder", params = "confirmed")
    public String newOrder(OrderForm orderForm, SessionStatus status,
            RedirectAttributes attributes) {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
            Account account = userDetails.getAccount();
            Order order = new Order();
            order.initOrder(account, cart);
            beanMapper.map(orderForm, order);
            orderService.insertOrder(order);//插入订单
            attributes.addAttribute("orderId", order.getOrderId());//为下一页显示订单内容而获取订单
            attributes.addFlashAttribute("message","感谢这次购物，您的订单已提交");//设置跳转后横幅显示信息
            status.setComplete();
    	}
        return "redirect:/order/viewOrder";
    }

    @RequestMapping("viewOrder")
    //我的账户查看订单点击订单编号后查看具体内容
    public String viewOrder(@RequestParam("orderId") int orderId, Model model) {
        Order order = orderService.getOrder(orderId);
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(obj instanceof UserDetails) {
        	UserDetails userDetails = (UserDetails)obj ;
            Account account = userDetails.getAccount();
            if (account.getUsername().equals(order.getUsername())) {
                model.addAttribute(order);
                return "order/ViewOrder";
            } else {
                model.addAttribute("你只能看你自己的订单");
                return "common/Error";
            }
        } else {
        	model.addAttribute("请登录账号");
            return "common/Error";
        }
    }

    @RequestMapping("listOrders")
    //我的账户查看订单
    public String listOrders(Model model) {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
            String username = userDetails.getUsername();
            List<Order> orderList = orderService.getOrdersByUsername(username);
            model.addAttribute("orderList", orderList);
    	}
        return "order/ListOrders";
    }
}

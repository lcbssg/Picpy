package com.cb.lee.app.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.Address;
import com.cb.lee.domain.model.UserDetails;
import com.cb.lee.domain.service.account.AccountService;
import com.cb.lee.domain.service.account.AddressService;

@Controller
@RequestMapping("account")
public class AccountController {

    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;

    @Inject
    protected Mapper beanMapper;
    @Inject
    protected RegisterValidator registerValidator;
    @Inject
    protected EditPswValidator editPswValidator;
    @Inject
    protected AccountService accountService;
    @Inject
    protected AddressService addressService;

    //用于初始化下拉框。找这个思路可以初始化area下拉框
    static {
        List<String> langList = new ArrayList<String>();
        langList.add("english");
        langList.add("japanese");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);
        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");
        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }
    
    
    @InitBinder("accountForm")
    //绑定注册验证器
    public void initBinder1(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(registerValidator);
    }
    
    @InitBinder("editPswForm")
    //绑定修改验证器
    public void initBinder2(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(editPswValidator);
    }
  
    @InitBinder("address")
    //TODO 地址表单的error，不知道函数能删吗，注解能删吗
    public void initBinder3(WebDataBinder webDataBinder) {
    }

    //登录
    @RequestMapping("signonForm")
    public String signonForm() {
        return "account/SignonForm";
    }
    
    //注册
    @RequestMapping("newAccountForm")
    public String newAccountForm() {
        return "account/NewAccountForm";
    }
    @RequestMapping("newAccount")
    public String newAccount(
            @Validated AccountForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return "account/NewAccountForm";
        }
        Account account = beanMapper.map(form, Account.class);
        accountService.insertAccount(account);
        return "redirect:/account/signonForm";
    }
    
    //密码修改
    @RequestMapping("editAccountForm")
    public String editAccountForm() {
        return "account/EditAccountForm";
    }
    @RequestMapping("editAccount")
    public String editAccount(
            @Validated EditPswForm form,
            BindingResult result) {
        if (result.hasErrors()) {//如果有错提示错误
            return "account/EditAccountForm";
        }
        Object obj = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
            Account account = userDetails.getAccount();//得到了当前账户
            account.setPassword(form.getPassword());
            accountService.updateAccount(account);
    	}
        return "redirect:/account/info";
    }
    
    //显示地址信息
    @RequestMapping("info")
    public String info(Model model) {
    	Object obj = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
            Account account = userDetails.getAccount();//得到了当前账户
            Address address = addressService.getAddress(account);
            if(address != null) {
            	model.addAttribute(address);
            }
    	}
        return "account/Info";
    }
    
    //地址修改
    @RequestMapping("editAddrForm")
    public String editAddrForm(Model model) {
    	Object obj = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
    		Account account = userDetails.getAccount();//得到了当前账户
            Address address = addressService.getAddress(account);
            if(address != null) {
            	model.addAttribute(address);
            }
    	}
        return "account/EditAddrForm";
    }
    @RequestMapping("editAddr")
    public String editAddr(@Validated AddressForm addressForm,
            BindingResult result) {
    	if (result.hasErrors()) {//如果有错提示错误
            return "account/EditAddrForm";
        }
    	Object obj = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    	if(obj instanceof UserDetails) {
    		UserDetails userDetails = (UserDetails) obj;
    		Account account = userDetails.getAccount();//得到了当前账户
            addressForm.setUsername(account.getUsername());
            Address address = beanMapper.map(addressForm, Address.class);
            if(addressService.getAddress(account) == null) {
            	addressService.insertAddress(address);
            } else {
            	addressService.updateAddress(address);
            }
    	}
        return "redirect:/account/info";
    }
}

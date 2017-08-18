package com.cb.lee.app.catalog;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cb.lee.domain.model.Flower;
import com.cb.lee.domain.service.catalog.CatalogService;

@Controller
@RequestMapping("catalog")
public class CatalogController {
    @Inject
    protected CatalogService catalogService;

    @RequestMapping
    //主页
    public String main() {
        return "catalog/Main";
    }
    
    @RequestMapping("viewFlower")
    //选择花种后的页面
    public String viewCategory(@RequestParam("flowerName") String flowerName,
            Model model) {
    	try {
			flowerName = new String(flowerName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			flowerName = "";
		}
    	List<Flower> flowerList =  catalogService.getFlowerListByName(flowerName);
        model.addAttribute("flowerList", flowerList);
        model.addAttribute("flowerName", flowerName);
        return "catalog/Flower";
    }
    
    @RequestMapping("viewDetail")
    //选择颜色后的详细页面
    public String viewItem(@RequestParam("flowerName") String flowerName,
    		@RequestParam("color") String color, Model model) {
    	try {
			flowerName = new String(flowerName.getBytes("ISO-8859-1"),"UTF-8");
			color = new String(color.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			flowerName = "";
			color = "";
		}
    	Flower flower = catalogService.getFlowerDetails(flowerName, color);
    	System.out.println(flower.getImg());
        model.addAttribute("flower", flower);
        return "catalog/Detail";
    }
    
    @RequestMapping(params = "keyword")
    //搜索框，实现搜索功能，显示产品了列表
    public String searchProducts(@Validated FlowerSearchForm form,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "common/Error";
        }
        String keyword = form.getKeyword().toLowerCase();
        List<Flower> flowerList = catalogService.searchFlowerList(keyword);
        model.addAttribute("flowerList", flowerList);
        return "catalog/SearchFlower";
    }
}

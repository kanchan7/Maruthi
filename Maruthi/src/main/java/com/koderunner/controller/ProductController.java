package com.koderunner.controller;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koderunner.service.ProductService;
import com.koderunner.vo.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product")
	public String setupForm(Map<String,Object> map ){
		Product product = new Product();
		map.put("product", product);
		map.put("productList", productService.getAllProduct());
		return "product";
		
	}
	
	@RequestMapping(value="/product.do",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Product product,BindingResult result,@RequestParam String action, Map<String,Object> map){
		Product productResult = new Product();
		
		switch(action.toLowerCase()){
			case "add": productService.addProduct(product); 
						productResult = product;
						break;
			case "edit":productService.editProduct(product);
						productResult = product;
						break;
			case "delete": productService.deleteProduct(product.getProductId());
						productResult = new Product();
						break;
			case "search":
						Product searchedProduct = productService.getProduct(product.getProductId());
						productResult = searchedProduct!=null ? searchedProduct : new Product();
						break;
		}
		
		map.put("product", productResult);
		map.put("productList", productService.getAllProduct());
		
		return "product";
		
	}
	
}

package com.koderunner.dao;

import java.util.List;

import com.koderunner.vo.Product;

public interface ProductDao  {

	public void addProduct(Product product);
	public void editProduct(Product product);
	public void deleteProduct(int productId);
	public Product getProduct(int productId);
	public List getAllProduct();
	
}

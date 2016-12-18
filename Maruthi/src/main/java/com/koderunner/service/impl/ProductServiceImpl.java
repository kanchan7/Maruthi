package com.koderunner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koderunner.dao.ProductDao;
import com.koderunner.service.ProductService;
import com.koderunner.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	@Transactional
	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

	@Transactional
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}

	@Transactional
	public Product getProduct(int productId) {
		
		return productDao.getProduct(productId);
	}
	
	@Transactional	
	public List getAllProduct() {

		return productDao.getAllProduct();
	}

}

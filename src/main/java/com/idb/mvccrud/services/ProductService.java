package com.idb.mvccrud.services;

import java.util.List;

import com.idb.mvccrud.entity.Product;


public interface ProductService {
	
	Product saveProduct(Product product);
	List<Product> getProduct();
	void deleteProduct(Long id);
	Product getProducts(Long id);
	 
}

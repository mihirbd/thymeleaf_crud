package com.idb.mvccrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idb.mvccrud.entity.Product;
import com.idb.mvccrud.repository.ProductRepository;

@Service
public class ProductServiceInplment implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = new Product();
		product.setId(id);
		productRepository.delete(product);	
	}

	@Override
	public Product getProducts(Long id) {
		return productRepository.findById(id).orElse(new Product());
	}

}

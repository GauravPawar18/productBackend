package com.example.ProductMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductMangement.model.Product;
import com.example.ProductMangement.repositery.ProductRepositery;


@Service
public class ProductServiceIMPL implements ProductService{
      
	
	
	@Autowired
	
	 private ProductRepositery productRepo;
	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product=productRepo.findById(id).get();
		if(product!=null)
		{
			productRepo.delete(product);
			return "Product Delete SuccesFully";
		}
		return "SomeThing Wrong on Server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		Product oldproduct=productRepo.findById(id).get();
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		return productRepo.save(oldproduct);
	}

}

package com.example.ProductMangement.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductMangement.model.Product;

public interface ProductRepositery  extends JpaRepository<Product,Integer> {

}

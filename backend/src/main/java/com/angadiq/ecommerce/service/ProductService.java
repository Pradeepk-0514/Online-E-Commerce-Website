package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.entity.Product;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

}
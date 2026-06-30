package com.angadiq.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.entity.Product;
import com.angadiq.ecommerce.repository.ProductRepository;
import com.angadiq.ecommerce.service.ProductService;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(

            ProductRepository productRepository

    ) {

        this.productRepository = productRepository;

    }

    @Override

    public Product createProduct(

            Product product

    ) {

        return productRepository.save(

                product

        );

    }

    @Override

    public List<Product> getAllProducts() {

        return productRepository.findAll();

    }

}
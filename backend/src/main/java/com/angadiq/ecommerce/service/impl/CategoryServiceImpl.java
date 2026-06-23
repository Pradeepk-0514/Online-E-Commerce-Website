package com.angadiq.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.entity.Category;
import com.angadiq.ecommerce.repository.CategoryRepository;
import com.angadiq.ecommerce.service.CategoryService;

@Service

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(

            CategoryRepository categoryRepository

    ) {

        this.categoryRepository = categoryRepository;

    }

    @Override

    public Category createCategory(

            Category category

    ) {

        return categoryRepository.save(

                category

        );

    }

    @Override

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();

    }

}
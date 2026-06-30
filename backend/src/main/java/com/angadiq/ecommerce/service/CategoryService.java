package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

}
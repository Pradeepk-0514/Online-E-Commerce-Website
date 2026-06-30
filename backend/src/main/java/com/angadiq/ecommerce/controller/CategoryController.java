package com.angadiq.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angadiq.ecommerce.entity.Category;
import com.angadiq.ecommerce.service.CategoryService;

@RestController

@RequestMapping("/api/categories")

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(

            CategoryService categoryService

    ) {

        this.categoryService = categoryService;

    }

    @PostMapping

    public ResponseEntity<Category>

    createCategory(

            @RequestBody Category category

    ) {

        return ResponseEntity.ok(

                categoryService.createCategory(

                        category

                )

        );

    }

    @GetMapping

    public ResponseEntity<List<Category>>

    getAllCategories() {

        return ResponseEntity.ok(

                categoryService.getAllCategories()

        );

    }

}
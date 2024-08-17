package com.example.eshop.service;


import com.example.eshop.entity.Category;
import com.example.eshop.entity.Product;
import com.example.eshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public String createCategory(Category category) {
        categoryRepository.save(category);
        return "Category created successfully";
    }





}

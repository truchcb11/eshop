package com.example.eshop.service;


import com.example.eshop.entity.Brand;
import com.example.eshop.entity.Category;
import com.example.eshop.entity.Product;
import com.example.eshop.repository.BrandRepository;
import com.example.eshop.repository.CategoryRepository;
import com.example.eshop.repository.ProductRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private CategoryService categoryService;

    private final ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
         return productRepository.save(product);

    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> advancedSearch(String name, String description, Double minPrice, Double maxPrice, Long categoryId, Long brandId) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            if (description != null && !description.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("description"), "%" + description + "%"));
            }

            if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            if (categoryId != null) {
                predicates.add(criteriaBuilder.equal(root.get("category").get("categoryId"), categoryId));
            }

            if (brandId != null) {
                predicates.add(criteriaBuilder.equal(root.get("brand").get("brandId"), brandId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }



    public List<Product> findAllByCategory(String categoryName){
        Category category = categoryRepository.findByCategoryName(categoryName);
        if (category == null) {
            throw new RuntimeException("Category not found: " + categoryName);
        }
        return productRepository.findAllByCategory(category);
    }

    public List<Product> findAllByBrand(String brandName){
        Brand brand = brandRepository.findByName(brandName) ;
        if (brand == null) {
            throw new RuntimeException("Brand not found: " + brandName);
        }

        return productRepository.findAllByBrand(brand);
    }

    public List<Product> findAllByName(String name){
        return productRepository.findAllByName(name);
    }

    public List<Product> findAllByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }





}




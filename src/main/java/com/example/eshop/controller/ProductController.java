package com.example.eshop.controller;



import com.example.eshop.entity.Product;
import com.example.eshop.repository.ProductRepository;
import com.example.eshop.service.CategoryService;
import com.example.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long brandId) {
        return productService.advancedSearch(name, description, minPrice, maxPrice, categoryId, brandId);
    }

    @GetMapping("/searchByCategory/{categoryName}")
    public Iterable<Product> searchProductsByCategory(@PathVariable String categoryName ) {
        return productService.findAllByCategory(categoryName);
    }


    @GetMapping("/searchByBrand/{brandName}")
    public Iterable<Product> searchProductsByBrand(@PathVariable String brandName ) {
        return productService.findAllByBrand(brandName);
    }

//    @GetMapping("/searchByName/{productName}")
//    public Iterable<Product> searchProductsByName(@PathVariable String productName ) {
//        return productService.findAllByName(productName);
//    }

    @GetMapping("/searchByNameContaining/{productName}")
    public Iterable<Product> searchProductsByNameContaining(@PathVariable String productName ) {
        return productService.findAllByNameContainingIgnoreCase(productName);
    }
}

package com.example.eshop.repository;

import com.example.eshop.entity.Brand;
import com.example.eshop.entity.Category;
import com.example.eshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{


    List<Product> findAllByCategory(Category category);

    List<Product> findAllByBrand(Brand brand);

    List<Product> findAllByName(String name);

    List<Product> findByNameContainingIgnoreCase(String name);
}

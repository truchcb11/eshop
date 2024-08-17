package com.example.eshop.repository;

import com.example.eshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {


    Brand findByName(String brandName);
}
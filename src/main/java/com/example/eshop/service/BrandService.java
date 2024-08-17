package com.example.eshop.service;


import com.example.eshop.entity.Brand;
import com.example.eshop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;



    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public String createBrand(Brand brand) {
        brandRepository.save(brand);
        return "Brand created successfully";
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }



}

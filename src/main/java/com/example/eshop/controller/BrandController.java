package com.example.eshop.controller;


import com.example.eshop.entity.Brand;
import com.example.eshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public String createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }


}

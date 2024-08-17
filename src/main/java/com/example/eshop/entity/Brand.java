package com.example.eshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "brand")
@Data
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_Id", nullable = false)
    private Long brandId;

    private String name;

    public Brand(Long brandId) {
        this.brandId = brandId;
    }

    public Brand() {

    }





}

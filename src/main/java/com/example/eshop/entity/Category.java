package com.example.eshop.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    public Category(Long categoryId) {
        this.categoryId = categoryId;

    }

    public Category() {

    }
}

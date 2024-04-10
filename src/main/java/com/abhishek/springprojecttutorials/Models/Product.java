package com.abhishek.springprojecttutorials.Models;

import com.abhishek.springprojecttutorials.dto.ProductServiceDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String imageURL;

    public Product(){
        this.id = null;
        this.title = null;
        this.description = null;
        this.price = 0.0;
        this.category = null;
        this.imageURL = null;
    }
    public Product(Long id, String title, String description, double price, Category category, String imageURL){
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageURL = imageURL;
    }
}

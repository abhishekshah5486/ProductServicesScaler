package com.abhishek.springprojecttutorials.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceDto {
    //   DATA TRANSFER OBJECT
    private Long id;
    private String title;
    private Double price;
    private String category;
    String description;
    String image;

}

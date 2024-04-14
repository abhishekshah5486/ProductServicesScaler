package com.abhishek.springprojecttutorials.services;

import com.abhishek.springprojecttutorials.Models.Product;
import com.abhishek.springprojecttutorials.dto.ProductServiceDto;

import java.util.List;

public interface ProductServiceInterface {

    Product mapToProduct(ProductServiceDto productServiceDto);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);

    Product deleteProduct(Long id);
    Product updateProduct(Product product);

    List<Product> getLimitedProducts(Long limit);
    List<Product> getSortedProducts(String order);

}

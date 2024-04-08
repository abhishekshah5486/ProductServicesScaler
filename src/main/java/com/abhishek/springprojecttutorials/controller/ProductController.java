package com.abhishek.springprojecttutorials.controller;

import com.abhishek.springprojecttutorials.Models.Product;
import com.abhishek.springprojecttutorials.dto.ProductServiceDto;
import com.abhishek.springprojecttutorials.services.FakeStoreProductService;
//import com.abhishek.springprojecttutorials.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    FakeStoreProductService productService = new FakeStoreProductService();
//    ProductService ps;
//    ProductController(ProductService ps){
//        this.ps = ps;
//    }
    // Getting details of all the products as a List<String>
    @GetMapping("/products/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    // Getting details of a specific product using the product ID
//    @GetMapping("/products/{id}/")
//    public String getProductById(@PathVariable("id") String id){
//        return"Details of Product with ID : " + id;
//    }
//    ProductService ps = new ProductService();
//    @GetMapping("/products/{id}/")
//    public ProductServiceDto getProductById(@PathVariable("id") Long id){
//        return ps.getProductById(id);
//    }
    @GetMapping("/products/{id}/")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products/")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/products/{id}/")
    public Product deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("/products?limit={limit}")
    public List<Product> limitResults(@PathVariable("limit") Long limit){
        return productService.getLimitedProducts(limit);
    }

    @GetMapping("/products?limit={order}")
    public List<Product> sortLists(@PathVariable("order") String order){
        return productService.getSortedProducts(order);
    }
}

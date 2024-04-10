//package com.abhishek.springprojecttutorials.services;
//
//import com.abhishek.springprojecttutorials.Models.Product;
//import com.abhishek.springprojecttutorials.Models.Category;
//import com.abhishek.springprojecttutorials.dto.ProductServiceDto;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class ProductService {
//    RestTemplate restTemplate = new RestTemplate();
//    String url = "https://fakestoreapi.com";
////    public String getAllProducts
//
//    public Product getProductById(Long id){
////        return "Product from service with id " + id;
//        ProductServiceDto productServiceDto = restTemplate.getForObject(
//                url+"/products/"+id,
//                ProductServiceDto.class
//        );
//        Product product = new Product();
//        product.setId(productServiceDto.getId());
//        product.setCategory(new Category());
//        product.getCategory().setName(productServiceDto.getCategory());
//        product.setPrice(productServiceDto.getPrice());
//        product.setDescription(productServiceDto.getDescription());
//        product.setTitle(productServiceDto.getTitle());
//        product.setImageURL(productServiceDto.getImage());
//
//        return product;
//    }
//    public ProductServiceDto[] getAllProducts(){
//        ProductServiceDto response[] = restTemplate.getForObject(url+"/products/", ProductServiceDto[].class);
//        return response;
//    }
//}
//

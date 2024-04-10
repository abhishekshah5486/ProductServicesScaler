package com.abhishek.springprojecttutorials.services;

import com.abhishek.springprojecttutorials.Models.Category;
import com.abhishek.springprojecttutorials.Models.Product;
import com.abhishek.springprojecttutorials.dto.FakeStoreProductDto;
import com.abhishek.springprojecttutorials.dto.ProductServiceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com/products";

    public Category mapToCategory(String categoryName){
        Category category = new Category();
        category.setName(categoryName);

        return category;
    }
    public List<Category> getAllCategories(){
        List<Category> result = new ArrayList<>();
        String[] categoryList = restTemplate.getForObject(
                url + "/categories",
                String[].class
        );
        assert categoryList != null;
        for (String str : categoryList){
            result.add(mapToCategory(str));
        }
        return result;
    }

    public List<Product> getProductsByCategory(String name){
        List<Product> result = new ArrayList<>();
        ProductServiceDto[] productList = restTemplate.getForObject(
                url + "/category/" + name,
                ProductServiceDto[].class
        );
        assert  productList != null;
        FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();
        for (int j=0; j<productList.length; j++){
            Category category = new Category();
            category.setName(productList[j].getCategory());
            Product product = new Product(productList[j].getId(), productList[j].getTitle(), productList[j].getDescription(), productList[j].getPrice(), category, productList[j].getImage());
//            result.add(FakeStoreProductService.mapToProduct(productList[j]));
            result.add(product);
        }
        return result;
    }
}

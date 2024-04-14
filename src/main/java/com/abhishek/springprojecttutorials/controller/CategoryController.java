package com.abhishek.springprojecttutorials.controller;

import com.abhishek.springprojecttutorials.Models.Category;
import com.abhishek.springprojecttutorials.Models.Product;
import com.abhishek.springprojecttutorials.services.CategoryService;
import com.abhishek.springprojecttutorials.services.FakeStoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

//    @GetMapping("/category")
////    @GetMapping("/products")
//    public String getAllCategories() {
//        return "All Categories";
//    }

    // getting details of a specific category
//    @GetMapping("/category/{id}")
//    public String getCategoryById(@PathVariable("id") Long id){
//        return "Category ID : " + id;
//    }
//    @Autowired
//    CategoryService cs;
//
//    @GetMapping("/category/{id}/")
//    public String getCategoryById(@PathVariable("id") Long id){
//        CategoryService cs = new CategoryService();
//        return cs.getCategoryById(id);
//    }

    FakeStoreCategoryService categoryService = new FakeStoreCategoryService();

    @GetMapping("/categories/")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{name}")
    public List<Product> getProductsByCategory(@PathVariable("name") String name){
        return categoryService.getProductsByCategory(name);
    }
}

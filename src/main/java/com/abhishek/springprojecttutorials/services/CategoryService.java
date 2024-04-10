package com.abhishek.springprojecttutorials.services;

import com.abhishek.springprojecttutorials.Models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
@Service
public class CategoryService {
    public String getCategoryById(Long id){
        return "Category from service with id-->" + id;
    }

//    @GetMapping("/categories/")
//    public List<Category> getAllCategories(){
//        return new ArrayList<>();
//    }
}

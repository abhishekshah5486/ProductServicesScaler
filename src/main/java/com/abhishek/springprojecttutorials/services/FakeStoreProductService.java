package com.abhishek.springprojecttutorials.services;

import com.abhishek.springprojecttutorials.Models.Category;
import com.abhishek.springprojecttutorials.Models.Product;
import com.abhishek.springprojecttutorials.dto.FakeStoreProductDto;
import com.abhishek.springprojecttutorials.dto.ProductServiceDto;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductServiceInterface{
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";

    @Override
    public Product mapToProduct(ProductServiceDto productServiceDto) {
        Category category = new Category();
        category.setName(productServiceDto.getCategory());
        return new Product(productServiceDto.getId(), productServiceDto.getTitle(), productServiceDto.getDescription(), productServiceDto.getPrice(), category, productServiceDto.getImage());
    }

    //    public String getAllProducts
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        ProductServiceDto[] productServiceDto = restTemplate.getForObject(
                url + "/products/",
                ProductServiceDto[].class
        );
        for (int j=0; j<productServiceDto.length; j++){

            if (productServiceDto[j] != null){
                Product product = new Product();
                product.setId(productServiceDto[j].getId());
                product.setCategory(new Category());
                product.getCategory().setName(productServiceDto[j].getCategory());
                product.setPrice(productServiceDto[j].getPrice());
                product.setDescription(productServiceDto[j].getDescription());
                product.setTitle(productServiceDto[j].getTitle());
                product.setImageURL(productServiceDto[j].getImage());

                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        ProductServiceDto productServiceDto = restTemplate.getForObject(
                url+"/products/"+id,
                ProductServiceDto.class
        );
        Product product = new Product();
        product.setId(productServiceDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productServiceDto.getCategory());
        product.setPrice(productServiceDto.getPrice());
        product.setDescription(productServiceDto.getDescription());
        product.setTitle(productServiceDto.getTitle());
        product.setImageURL(productServiceDto.getImage());

        return product;
    }

    @Override
    public Product createProduct(Product product) {
        ProductServiceDto productServiceDto = new ProductServiceDto();

        productServiceDto.setTitle(product.getTitle());
        productServiceDto.setPrice(product.getPrice());
        productServiceDto.setDescription(product.getDescription());
        productServiceDto.setImage(product.getImageURL());
        productServiceDto.setCategory(product.getCategory().getName());

        ProductServiceDto response = restTemplate.postForObject(
                url + "/products/",productServiceDto,
                ProductServiceDto.class
        );
        assert response != null;
        return mapToProduct(response);
    }

    @Override
    public Product deleteProduct(Long id){
//        ProductServiceDto productServiceDto = restTemplate.delete(
//                url + "/products/" + id,
//                ProductServiceDto.class
//        );
        ResponseEntity<ProductServiceDto> response = restTemplate.exchange(
                url + "/products/" + id,
                HttpMethod.DELETE,
                null,
                ProductServiceDto.class
        );
        assert response.getBody() != null;
        return mapToProduct(response.getBody());
    }

    @Override
    public Product updateProduct(Product product) {
        ProductServiceDto productServiceDto = new ProductServiceDto();
        productServiceDto.setId(product.getId());
        productServiceDto.setCategory(product.getCategory().getName());
        productServiceDto.setTitle(product.getTitle());
        productServiceDto.setPrice(product.getPrice());
        productServiceDto.setImage(product.getImageURL());
        productServiceDto.setDescription(product.getDescription());

        ProductServiceDto updatedProduct = restTemplate.patchForObject(
                url + "/products/" + product.getId(),
                productServiceDto,
                ProductServiceDto.class
        );

        return mapToProduct(updatedProduct);
//        HttpEntity<ProductServiceDto> requestEntity = new HttpEntity<>(productServiceDto);
//        ResponseEntity<ProductServiceDto> response = restTemplate.exchange(
//                url + "/products/" + product.getId(),
//                HttpMethod.PUT,
//                requestEntity,
//                ProductServiceDto.class
//        );
//        assert response.getBody() != null;
//        return mapToProduct(response.getBody());
    }

    @Override
    public List<Product> getLimitedProducts(Long limit){
        List<Product> result = new ArrayList<>();
        ProductServiceDto[] limitedProducts = restTemplate.getForObject(
                url + "/products?limit=" + limit,
                ProductServiceDto[].class
        );
        assert limitedProducts != null;
        for(int j=0; j<limitedProducts.length; j++){
            Product temp = mapToProduct(limitedProducts[j]);
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<Product> getSortedProducts(String order){
        List<Product> result = new ArrayList<>();
        ProductServiceDto[] sortedProducts = restTemplate.getForObject(
                url + "/products?sort=" + order,
                ProductServiceDto[].class
        );
        assert sortedProducts != null;
        for (ProductServiceDto sortedProduct : sortedProducts) {
            Product temp = mapToProduct(sortedProduct);
            result.add(temp);
        }
        return result;
    }
}

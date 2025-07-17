package com.example.restapi.service;

import com.example.restapi.entity.Product;
import com.example.restapi.respository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private Productrepository productrepository;

    public List<Product> getallProduct(){
        return productrepository.findAll();
    }
    public Product getProductById(Long id){
        return productrepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }
    public Product createProduct(Product prod){
        return productrepository.save(prod);
    }
    public Product updateProduct(Long id, Product productDetauils){
        Product product = getProductById(id);
        product.setName(productDetauils.getName());
        product.setPrice(productDetauils.getPrice());
        return productrepository.save(product);
    }
    public void deleteProduct(Long id){
          productrepository.deleteById(id);
    }

//    public List<Product> searchProduct(String name,double minPrice,double maxPrice){
//        List<Product> allProducts = getallProduct();
//        return allProducts.stream().filter(p->(name==null||p.getName().toLowerCase().contains(name.toLowerCase()))).filter(p->(p.getPrice()>=minPrice)).filter(p->(p.getPrice()<=maxPrice)).collect(Collectors.toList());
//    }
    public List<Product> getProductByName(String name){
        return productrepository.findByNameContainingIgnoreCase(name);

    }
}

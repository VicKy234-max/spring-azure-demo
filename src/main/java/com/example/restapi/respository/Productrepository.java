package com.example.restapi.respository;


import com.example.restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Productrepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContainingIgnoreCase(String name);


}

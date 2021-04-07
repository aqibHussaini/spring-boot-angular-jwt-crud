package com.example.demo.repository;

import com.example.demo.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM Product  WHERE name = %?1%",
            nativeQuery = true)
public List<Product> search(String query);
}

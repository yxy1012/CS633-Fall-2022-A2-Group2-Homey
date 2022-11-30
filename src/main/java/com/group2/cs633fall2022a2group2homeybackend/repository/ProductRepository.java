package com.group2.cs633fall2022a2group2homeybackend.repository;

import com.group2.cs633fall2022a2group2homeybackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

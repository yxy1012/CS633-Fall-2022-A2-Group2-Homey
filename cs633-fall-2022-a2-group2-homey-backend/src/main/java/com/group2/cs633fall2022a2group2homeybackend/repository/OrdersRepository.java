package com.group2.cs633fall2022a2group2homeybackend.repository;

import com.group2.cs633fall2022a2group2homeybackend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    public List findByUser_id(Integer id);
}

package com.group2.cs633fall2022a2group2homeybackend.repository;

import com.group2.cs633fall2022a2group2homeybackend.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}

package com.group2.cs633fall2022a2group2homeybackend.repository;

import com.group2.cs633fall2022a2group2homeybackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List findByEmail(String email);
}

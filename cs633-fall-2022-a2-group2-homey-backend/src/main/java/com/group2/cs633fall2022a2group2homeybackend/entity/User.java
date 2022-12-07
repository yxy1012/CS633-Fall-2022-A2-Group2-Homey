package com.group2.cs633fall2022a2group2homeybackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data

public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;
    private String apartment;
    private String city;
    private String postal_code;
}

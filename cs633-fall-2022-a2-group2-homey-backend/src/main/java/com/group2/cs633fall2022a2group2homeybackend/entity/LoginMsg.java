package com.group2.cs633fall2022a2group2homeybackend.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginMsg {
    private int id;

    private String email;

    private boolean login;
}

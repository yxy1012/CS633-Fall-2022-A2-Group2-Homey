package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Shoppingcarts;
import com.group2.cs633fall2022a2group2homeybackend.entity.Users;
import com.group2.cs633fall2022a2group2homeybackend.entity.Wishlist;
import com.group2.cs633fall2022a2group2homeybackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/findAll")
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody Users users){
        Users result = usersRepository.save(users);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Users findById(@PathVariable("id") Integer id){
        return usersRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Users users){
        Users result = usersRepository.save(users);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        usersRepository.deleteById(id);
    }
}

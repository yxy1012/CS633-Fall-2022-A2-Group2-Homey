package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Shoppingcarts;
import com.group2.cs633fall2022a2group2homeybackend.entity.Wishlist;
import com.group2.cs633fall2022a2group2homeybackend.repository.ShoppingcartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/shoppingcarts")

public class ShoppingcartsController {

    @Autowired

    ShoppingcartsRepository shoppingcartsRepository;

    @RequestMapping("/findAll")
    public List<Shoppingcarts> findAll(){
        return shoppingcartsRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody Shoppingcarts shoppingcarts){
        Shoppingcarts result = shoppingcartsRepository.save(shoppingcarts);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Shoppingcarts findById(@PathVariable("id") Integer id){
        return shoppingcartsRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody List<Shoppingcarts> list){
        for(int i = 0; i < list.size(); i++){
            Shoppingcarts shoppingcarts = list.get(i);
            Shoppingcarts result = shoppingcartsRepository.save(shoppingcarts);
            if (result == null){
                return "error";
            }
        }
        return "success";
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        shoppingcartsRepository.deleteById(id);
    }

    @PutMapping("/deleteAll")
    public void deleteAll(@RequestBody List<Shoppingcarts> list){
        System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            Shoppingcarts shoppingcarts = list.get(i);
            shoppingcartsRepository.deleteById(shoppingcarts.getId());
        }
    }

    @GetMapping("/findByUserId/{id}")
    public List<Shoppingcarts> findByUserId(@PathVariable("id") Integer id){
        return shoppingcartsRepository.findByUser_id(id);
    }
}

package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Shoppingcarts;
import com.group2.cs633fall2022a2group2homeybackend.entity.Wishlist;
import com.group2.cs633fall2022a2group2homeybackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")

public class WishlistController {
    @Autowired
    WishlistRepository wishlistRepository;

    @RequestMapping("/findAll")
    public List<Wishlist> findAll(){
        return wishlistRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody Wishlist wishlist){
        Wishlist result = wishlistRepository.save(wishlist);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Wishlist findById(@PathVariable("id") Integer id){
        return wishlistRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Wishlist wishlist){
        Wishlist result = wishlistRepository.save(wishlist);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        System.out.println("delete");
        wishlistRepository.deleteById(id);
    }
}

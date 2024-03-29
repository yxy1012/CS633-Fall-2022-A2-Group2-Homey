package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Wishlist;
import com.group2.cs633fall2022a2group2homeybackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public boolean deleteById(@PathVariable("id") Integer id){
        wishlistRepository.deleteById(id);
        return true;
    }

    @GetMapping("/findByUserId/{id}")
    public List<Wishlist> findByUserId(@PathVariable("id") Integer id){
        return wishlistRepository.findByUser_id(id);
    }
}

package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Product;
import com.group2.cs633fall2022a2group2homeybackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/findAll")
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody Product product){
        Product result = productRepository.save(product);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Product findById(@PathVariable("id") Integer id){
        return productRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Product product){
        Product result = productRepository.save(product);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
    }

}

package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.OrderDetails;
import com.group2.cs633fall2022a2group2homeybackend.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @RequestMapping("/findAll")
    public List<OrderDetails> findAll(){
        return orderDetailsRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody OrderDetails orderdetails){
        OrderDetails result = orderDetailsRepository.save(orderdetails);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public OrderDetails findById(@PathVariable("id") Integer id){
        return orderDetailsRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody OrderDetails orderdetails){
        OrderDetails result = orderDetailsRepository.save(orderdetails);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        orderDetailsRepository.deleteById(id);
    }

}

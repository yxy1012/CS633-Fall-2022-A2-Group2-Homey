package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.Orders;
import com.group2.cs633fall2022a2group2homeybackend.entity.Wishlist;
import com.group2.cs633fall2022a2group2homeybackend.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping("/findAll")
    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }
    @PostMapping("/save")
    public String save (@RequestBody Orders orders){
        Orders result = ordersRepository.save(orders);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/saveAll")
    public String saveAll (@RequestBody List<Orders> orders){
        Orders result = null;
        for(int i = 0; i < orders.size(); i++){
            result = ordersRepository.save(orders.get(i));
            if (result == null){
                return "error";
            }
        }
        return "success";
    }

    @GetMapping("/findById/{id}")
    public Orders findById(@PathVariable("id") Integer id){
        return ordersRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Orders orders){
        Orders result = ordersRepository.save(orders);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        ordersRepository.deleteById(id);
    }

    @GetMapping("/findByUserId/{id}")
    public List<Orders> findByUserId(@PathVariable("id") Integer id){
        return ordersRepository.findByUser_id(id);
    }

}

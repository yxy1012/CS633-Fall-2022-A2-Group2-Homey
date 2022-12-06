package com.group2.cs633fall2022a2group2homeybackend.controller;

import com.group2.cs633fall2022a2group2homeybackend.entity.LoginMsg;
import com.group2.cs633fall2022a2group2homeybackend.entity.User;
import com.group2.cs633fall2022a2group2homeybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UsersController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String save (@RequestBody User user){
        List list = userRepository.findByEmail(user.getEmail());
        if(list.size() > 1){
            return "This email already exists";
        }else{
            User result = userRepository.save(user);
            if (result != null){
                return "success";
            }else{
                return "error";
            }
        }
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @Resource
    LoginMsg msg;
    @GetMapping("/login/{email}/{password}")
    @ResponseBody
    public LoginMsg Login(@PathVariable("email") String email, @PathVariable("password") String password) {
        List<User> list = userRepository.findByEmail(email);
        User user = null;
        if(list.size() > 0){
            user = list.get(0);
        }
        if(user != null && user.getPassword().equals(password)){
            msg.setId(user.getId());
            msg.setEmail(user.getEmail());
            msg.setLogin(true);
        }
        else {
            msg.setLogin(false);
        }
        return msg;
    }
}

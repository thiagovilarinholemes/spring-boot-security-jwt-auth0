package com.thiago.resources;

import com.thiago.entities.User;
import com.thiago.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Home {

    @Autowired
    private UserService service;

    // Available to all authenticated users
    @GetMapping("test1")
    public String test1(){
        return "Tudo OK Test1, todos podem ver";
    }

    @GetMapping("test2")
    public String test2(){
        return "Tudo OK Test2, somente o MANAGER pode ver";
    }

    @GetMapping("test3")
    public String test3(){
        return "Tudo OK Test3, somente o ADMIN pode ver";
    }

    @GetMapping("users")
    public List<User> test4(){
        return service.findAll();
    }

    // Available to managers
    @GetMapping("reports")
    public String reports(){
        return "Some report data";
    }
}

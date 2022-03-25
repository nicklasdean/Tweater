package com.example.tweeter.controllers;

import com.example.tweeter.repositores.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TweeterController {
    private final TestRepository testRepo = new TestRepository();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}

package com.example.tweeter.controllers;

import com.example.tweeter.models.Tweat;
import com.example.tweeter.repositores.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TweeterController {
    private final TestRepository testRepo = new TestRepository();

    @GetMapping("/")
    public String index(Model m){
        List<Tweat> listOfAllTweats = testRepo.getAllTweats();
        m.addAttribute("allTweats",listOfAllTweats);
        return "index";
    }

    @GetMapping("/test")
    public String test(Model m){
        m.addAttribute("tweat", new Tweat("Hey allesammen"));
        return "test";
    }
}

package com.example.tweeter.controllers;

import com.example.tweeter.models.Tweat;
import com.example.tweeter.repositores.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TweeterController {
    private final TestRepository testRepo = new TestRepository();

    @GetMapping("/")
    public String index(Model thingThatTransportDataToView){
        List<Tweat> allTweats = testRepo.getAllTweats();
        thingThatTransportDataToView.addAttribute("allMyTweatsVariable", allTweats);
        return "index";
    }

    @GetMapping("/test")
    public String test(HttpSession session, Model model){
        String helloWorld = (String) session.getAttribute("username");
        model.addAttribute("message", helloWorld);
        return "test";
    }

    @PostMapping("/sessionTweat")
    public String sessionExample(HttpSession session){
        session.setAttribute("username","Hello World");
        return "redirect:/test";
    }
}

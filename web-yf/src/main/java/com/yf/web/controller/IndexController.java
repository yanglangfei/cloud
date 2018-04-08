package com.yf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public  String toIndex(Model model){
        model.addAttribute("user","john");
        return "index";
    }

}

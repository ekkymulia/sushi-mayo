package com.sushimayo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class PublicController {

    @RequestMapping("")
    public String Index(Model model){
        return "index.html";
    }

    @RequestMapping("/about")
    public String About(){
        return "about.html";
    }

    @RequestMapping("/contact")
    public String Contact(){
        return "contact.html";
    }
}

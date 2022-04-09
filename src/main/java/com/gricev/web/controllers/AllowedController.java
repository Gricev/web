package com.gricev.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllowedController {
    @GetMapping("/users/about")
    public String allowedAbout(Model model) {
        model.addAttribute("title", "О нас");
        return "allowedusers/allowedabout";
    }
    @GetMapping("/users/price")
    public String getPrice(Model model) {
        model.addAttribute("title", "Подписка");
        return "allowedusers/allowedprice";
    }
}

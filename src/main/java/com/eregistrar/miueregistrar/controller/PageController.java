package com.eregistrar.miueregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("index.html")
    public String index() {
        return "public/index";
    }
}

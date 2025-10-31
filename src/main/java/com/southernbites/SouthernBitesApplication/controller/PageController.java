package com.southernbites.SouthernBitesApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index"; // loads templates/index.html
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu"; // loads templates/menu.html
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking"; // loads templates/booking.html
    }
}

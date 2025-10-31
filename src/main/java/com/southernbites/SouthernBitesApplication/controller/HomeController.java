package com.southernbites.SouthernBitesApplication.controller;

import com.southernbites.SouthernBitesApplication.model.MenuItem;
import com.southernbites.SouthernBitesApplication.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final MenuItemService menuItemService;

    public HomeController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        // show a subset or featured items if required
        List<MenuItem> all = menuItemService.findAll();
        model.addAttribute("featured", all.stream().limit(4).collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        List<MenuItem> all = menuItemService.findAll();
        // group by category for categorized view
        Map<String, List<MenuItem>> menuByCategory = all.stream()
                .collect(Collectors.groupingBy(MenuItem::getCategory, LinkedHashMap::new, Collectors.toList()));

        model.addAttribute("menuByCategory", menuByCategory);
        return "menu";
    }
}

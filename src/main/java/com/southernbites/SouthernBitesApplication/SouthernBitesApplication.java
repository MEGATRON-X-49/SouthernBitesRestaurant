package com.southernbites.SouthernBitesApplication;

import com.southernbites.SouthernBitesApplication.model.MenuItem;
import com.southernbites.SouthernBitesApplication.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SouthernBitesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SouthernBitesApplication.class, args);
    }

    // Pre-populate 5 sample MenuItem records on startup
    @Bean
    CommandLineRunner initData(MenuItemRepository menuItemRepository) {
        return args -> {
            if (menuItemRepository.count() == 0) {
                menuItemRepository.save(new MenuItem(null, "Veg Thali", "A wholesome platter of seasonal vegetables, dal, rice, roti, and chutneys.", new BigDecimal("149.00"), "VEG", "/images/veg-thali.jpg"));
                menuItemRepository.save(new MenuItem(null, "Masala Dosa", "Crispy dosa stuffed with spiced potato, served with chutney and sambar.", new BigDecimal("99.00"), "DOSAS", "/images/masala-dosa.jpg"));
                menuItemRepository.save(new MenuItem(null, "Kacheguda Chicken Curry", "Spicy chicken curry slow cooked with Kacheguda spices.", new BigDecimal("219.00"), "NON-VEG", "/images/chicken-curry.jpg"));
                menuItemRepository.save(new MenuItem(null, "Ramnagar Fish Fry", "Fresh marinated fish shallow-fried with curry leaves and red chilies.", new BigDecimal("249.00"), "NON-VEG", "/images/fish-fry.jpg"));
                menuItemRepository.save(new MenuItem(null, "Musheerabad Mutton Kebab", "Charcoal grilled mutton kebab with Musheerabad masala.", new BigDecimal("299.00"), "NON-VEG", "/images/mutton-kebab.jpg"));
            }
        };
    }
}

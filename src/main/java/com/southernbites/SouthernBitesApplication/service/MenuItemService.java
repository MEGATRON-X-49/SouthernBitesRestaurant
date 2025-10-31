package com.southernbites.SouthernBitesApplication.service;

import com.southernbites.SouthernBitesApplication.model.MenuItem;
import com.southernbites.SouthernBitesApplication.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository repo;

    public MenuItemService(MenuItemRepository repo) {
        this.repo = repo;
    }

    public List<MenuItem> findAll() {
        return repo.findAllByOrderByCategoryAscNameAsc();
    }

    public MenuItem save(MenuItem item) {
        return repo.save(item);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

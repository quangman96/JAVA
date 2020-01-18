package com.codegym.cms.service.impl;

import com.codegym.cms.model.Item;
import com.codegym.cms.repository.ItemRepository;
import com.codegym.cms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void remove(Long id) {
        itemRepository.deleteById(id);
    }
}

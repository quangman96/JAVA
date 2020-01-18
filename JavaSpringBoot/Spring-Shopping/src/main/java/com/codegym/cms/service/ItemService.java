package com.codegym.cms.service;

import com.codegym.cms.model.Item;

public interface ItemService {
    Iterable<Item> findAll();

    Item findById(Long id);

    void save(Item order);

    void remove(Long id);
}

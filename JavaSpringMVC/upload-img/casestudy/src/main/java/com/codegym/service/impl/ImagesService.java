package com.codegym.service.impl;

import com.codegym.model.Images;


public interface ImagesService {
    Iterable<Images> findAll();
    Images findbyId(Long id);
    void save (Images images);
    void remove (Long id);

}

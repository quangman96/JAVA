package com.codegym.service;

import com.codegym.model.Images;
import com.codegym.model.User;
import com.codegym.repository.ImagesRepository;
import com.codegym.service.impl.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;

public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Override
    public Iterable<Images> findAll() {
        return imagesRepository.findAll();
    }

    @Override
    public Images findbyId(Long id) {
        return imagesRepository.findById(id).get();
    }

    @Override
    public void save(Images images) {
        imagesRepository.save(images);

    }

    @Override
    public void remove(Long id) {
        imagesRepository.deleteById(id);

    }
}

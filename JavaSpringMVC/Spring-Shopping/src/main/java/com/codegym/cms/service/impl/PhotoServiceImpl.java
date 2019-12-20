package com.codegym.cms.service.impl;

import com.codegym.cms.model.Photo;
import com.codegym.cms.repository.PhotoRepository;
import com.codegym.cms.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public Iterable<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Photo findById(int id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);

    }

    @Override
    public void remove(int id) {
        photoRepository.deleteById(id);

    }
}

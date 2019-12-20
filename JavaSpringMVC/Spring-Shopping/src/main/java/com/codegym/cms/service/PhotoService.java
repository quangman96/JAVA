package com.codegym.cms.service;

import com.codegym.cms.model.Photo;

public interface PhotoService {
    Iterable<Photo> findAll();
    Photo findById(int id);
    void save (Photo photo);
    void remove (int id);
}

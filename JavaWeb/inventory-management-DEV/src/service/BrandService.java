package service;

import model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    void save(Brand brand);

    Brand findById(int id);

    void update(int id, Brand brand);

    void remove(int id, Brand brand);
}

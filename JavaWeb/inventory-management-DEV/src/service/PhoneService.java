package service;

import model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();
    List<Phone> findByName(String inputValue);

    void save(Phone phone);

    Phone findById(int id);

    void update(int id, Phone phone);

    void remove(int id, Phone phone);

    List<Phone> findAllByIdBrand(int id);
}

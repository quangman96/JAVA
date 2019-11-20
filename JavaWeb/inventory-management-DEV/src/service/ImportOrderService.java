package service;

import model.ImportOrder;

import java.util.List;

public interface ImportOrderService {
    List<ImportOrder> findAll();

    void save(ImportOrder importOrder);

    ImportOrder findById(int id);

    ImportOrder findById_for_del(int id);

    void update(int id, ImportOrder importOrder);

    void remove(int id);


}

package service;

import model.DetailStock;

import java.util.List;

public interface DetailStockService {
    List<DetailStock> findAll();

    List<DetailStock> findByIdStock(int idStock);
    int AmoutPhoneByID(int id);

}

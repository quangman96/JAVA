package service;

import model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAll();

    void save(Stock stock);

    Stock findById(int id);

    void update(int id, Stock stock);

    void remove(int id, Stock stock);

    List<Stock> findAllCuong();
}

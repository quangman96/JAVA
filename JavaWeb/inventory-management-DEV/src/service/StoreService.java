package service;

import model.Store;

import java.util.List;

public interface StoreService {
    List<Store> findallStore();

    Store findByIdStore(int idStore);

    void saveStore(Store store);

    void updateStore(int idStore, Store store);

    void removeStore(int idStore, String deleteBy);
}

package service;


import model.DetailStore;

import java.util.List;

public interface DetailStoreService {
    List<DetailStore> findalldetailStore();
    List<DetailStore> findByIDStore(int idStore);
    int AmoutPhoneByID (int id);
}

package service;

import model.DetailImportOrder;

import java.util.List;

public interface DetailImportOrderService {
    List<DetailImportOrder> findByIDImportOrder (int idImportOrder);
}

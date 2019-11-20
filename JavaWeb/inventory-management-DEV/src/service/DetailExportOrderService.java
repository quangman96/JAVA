package service;

import model.DetailExportOrder;

import java.util.List;

public interface DetailExportOrderService {
    List<DetailExportOrder> findByIDExportOrder (int idExportOrder);

}

package service;

import model.DetailExportOrder;

import java.util.List;

public interface DetailExportService {
    List<DetailExportOrder> findAll() ;
    DetailExportOrder findById(int idExportOrder);

}

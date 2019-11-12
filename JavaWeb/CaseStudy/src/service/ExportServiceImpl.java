package service;

import model.ExportOrder;

import java.sql.SQLException;
import java.util.List;

public interface ExportServiceImpl {
    List<ExportOrder> findAll() ;

    void save (ExportOrder exportOrder);

    ExportOrder findById(int idExportOrder);

    void update (int idExportOrder, ExportOrder exportOrder);

    void remove (int idExport);
}

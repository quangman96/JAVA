package model;

public class ImportOrder {
    private int idImportOrder;
    private String name;
    private int idStock;
    private int idStaff;
    private String staffName;
    private String stockName;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String createBy;
    private String createDate;

    public ImportOrder(int idImportOrder, String name, int idStock, int idStaff, String staffName, String stockName, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idImportOrder = idImportOrder;
        this.name = name;
        this.idStock = idStock;
        this.idStaff = idStaff;
        this.staffName = staffName;
        this.stockName = stockName;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    //    List findAll
    public ImportOrder(int idImportOrder, String name, String staffName, String stockName, String createBy, String createDate) {
        this.idImportOrder = idImportOrder;
        this.name = name;
        this.staffName = staffName;
        this.stockName = stockName;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    //    createImportOrder
    public ImportOrder(int idImportOrder, String name, int idStaff, int idStock, String createBy) {
        this.idImportOrder = idImportOrder;
        this.name = name;
        this.idStock = idStock;
        this.idStaff = idStaff;
        this.createBy = createBy;
    }

    // findById_for_delete
    public ImportOrder(int idImportOrder, String name, String staffName, String stockName, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idImportOrder = idImportOrder;
        this.name = name;
        this.staffName = staffName;
        this.stockName = stockName;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    // Edit
    public ImportOrder(int idImportOrder, String name, String staffName, String stockName, String modifyBy) {
        this.idImportOrder = idImportOrder;
        this.name = name;
        this.staffName = staffName;
        this.stockName = stockName;
        this.modifyBy = modifyBy;
    }

    public int getIdImportOrder() {
        return idImportOrder;
    }

    public void setIdImportOrder(int idImportOrder) {
        this.idImportOrder = idImportOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}




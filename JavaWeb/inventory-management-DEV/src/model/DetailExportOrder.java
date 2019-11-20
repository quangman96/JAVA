package model;

public class DetailExportOrder {
    private int idExportOrder;
    private String exportOrderName;
    private String phoneName;
    private int phoneAmount;
    private String staffName;
    private String stockName;
    private String storeName;
    private String createBy;
    private String createDate;
    private String modifyBy;
    private String modifyDate;
    private String deleteBy;
    private String deleteDate;

    public DetailExportOrder() {
    }

    public DetailExportOrder(int idExportOrder, String phoneName, int phoneAmount, String staffName, String stockName, String storeName, String createBy, String createDate, String modifyBy, String modifyDate) {
        this.idExportOrder = idExportOrder;
        this.phoneName = phoneName;
        this.phoneAmount = phoneAmount;
        this.staffName = staffName;
        this.stockName = stockName;
        this.storeName = storeName;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public DetailExportOrder(int idExportOrder, String exportOrderName, String phoneName, int phoneAmount, String staffName, String stockName, String storeName, String createBy, String createDate, String modifyBy, String modifyDate, String deleteBy, String deleteDate) {
        this.idExportOrder = idExportOrder;
        this.exportOrderName = exportOrderName;
        this.phoneName = phoneName;
        this.phoneAmount = phoneAmount;
        this.staffName = staffName;
        this.stockName = stockName;
        this.storeName = storeName;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
    }

    public DetailExportOrder(String exportOrderName, String phoneName, int phoneAmount) {
        this.exportOrderName = exportOrderName;
        this.phoneName = phoneName;
        this.phoneAmount = phoneAmount;
    }

    public int getIdExportOrder() {
        return idExportOrder;
    }

    public void setIdExportOrder(int idExportOrder) {
        this.idExportOrder = idExportOrder;
    }

    public String getExportOrderName() {
        return exportOrderName;
    }

    public void setExportOrderName(String exportOrderName) {
        this.exportOrderName = exportOrderName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhoneAmount() {
        return phoneAmount;
    }

    public void setPhoneAmount(int phoneAmount) {
        this.phoneAmount = phoneAmount;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
}

package model;

public class DetailImportOrder {
    private int idImportOrder;
    private int phoneAmount;
    private String nameImportOrder;
    private String namePhone;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String createBy;
    private String createDate;
    public DetailImportOrder(int idImportOrder, int phoneAmount, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate){
        this.idImportOrder = idImportOrder;
        this.phoneAmount = phoneAmount;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public DetailImportOrder(int idImportOrder,int phoneAmount, String nameImportOrder, String namePhone) {
        this.idImportOrder =idImportOrder;
        this.phoneAmount = phoneAmount;
        this.nameImportOrder = nameImportOrder;
        this.namePhone = namePhone;
    }

    public String getNameImportOrder() {
        return nameImportOrder;
    }

    public void setNameImportOrder(String nameImportOrder) {
        this.nameImportOrder = nameImportOrder;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public int getIdImportOrder() { return idImportOrder; }

    public void setIdImportOrder(int idImportOrder) { this.idImportOrder = idImportOrder; }

    public int getPhoneAmount() {
        return phoneAmount;
    }

    public void setPhoneAmount(int phoneAmount) {
        this.phoneAmount = phoneAmount;
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


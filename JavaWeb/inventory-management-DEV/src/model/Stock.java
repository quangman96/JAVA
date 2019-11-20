package model;

public class Stock {
    private int idStock;
    private String name;
    private String address;
    private String phoneNumber;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String createBy;
    private String createDate;

    public Stock() {
    }

    public Stock(int idStock, String name, String address, String phoneNumber, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idStock = idStock;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

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

    public String getCreateBy() { return createBy; }

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

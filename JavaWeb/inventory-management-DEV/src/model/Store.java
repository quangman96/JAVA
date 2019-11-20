package model;

public class Store {
    private int idStore;
    private String nameStore;
    private String addressStore;
    private String phoneNumberStore;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String creatBy;
    private String creatDate;
    public Store(int idStore, String nameStore, String addressStore, String phoneNumberStore
            , String deleteBy, String deleteDate, String modifyBy, String modifyDate
            , String creatBy, String creatDate){
        this.idStore =idStore;
        this.nameStore =nameStore;
        this.addressStore =addressStore;
        this.phoneNumberStore = phoneNumberStore;
        this.deleteBy =deleteBy;
        this.deleteDate =deleteDate;
        this.modifyBy =modifyBy;
        this.modifyDate=modifyDate;
        this.creatBy =creatBy;
        this.creatDate =creatDate;
    }
    public Store(String nameStore, String addressStore, String phoneNumberStore, String creatBy) {
        this.nameStore =nameStore;
        this.addressStore =addressStore;
        this.phoneNumberStore = phoneNumberStore;
        this.creatBy =creatBy;
    }


    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getAddressStore() {
        return addressStore;
    }

    public void setAddressStore(String addressStore) {
        this.addressStore = addressStore;
    }

    public String getPhoneNumberStore() {
        return phoneNumberStore;
    }

    public void setPhoneNumberStore(String phoneNumberStore) {
        phoneNumberStore = phoneNumberStore;
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

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }
}

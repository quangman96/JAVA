package model;

public class DetailStore {
    private int idStore;
    private int idphone;
    private String phoneAmount;
    private String nameStore;
    private String namePhone;
    public DetailStore(int idStore, int idphone, String phoneAmount) {
        this. idStore = idStore;
        this.idphone =idphone;
        this.phoneAmount =phoneAmount;
    }
    public DetailStore(int idStore, int idphone) {
        this. idStore = idStore;
        this.idphone =idphone;
    }

    public DetailStore(String phoneAmount, String nameStore, String namePhone) {
        this.phoneAmount = phoneAmount;
        this.nameStore = nameStore;
        this.namePhone = namePhone;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getIdphone() {
        return idphone;
    }

    public void setIdphone(int idphone) {
        this.idphone = idphone;
    }

    public String getPhoneAmount() {
        return phoneAmount;
    }

    public void setPhoneAmount(String phoneAmount) {
        this.phoneAmount = phoneAmount;
    }
}

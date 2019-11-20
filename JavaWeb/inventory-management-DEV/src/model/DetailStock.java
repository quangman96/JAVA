package model;

public class DetailStock {
    private int idStock;
    private int idPhone;
    private int phoneAmount;
    private String nameStock;
    private String namePhone;

    public DetailStock() {
    }

    public DetailStock(int idStock, int idPhone, int phoneAmount) {
        this.idStock = idStock;
        this.idPhone = idPhone;
        this.phoneAmount = phoneAmount;
    }

    public DetailStock(int phoneAmount, String nameStock, String namePhone) {
        this.phoneAmount = phoneAmount;
        this.nameStock = nameStock;
        this.namePhone = namePhone;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public int getPhoneAmount() {
        return phoneAmount;
    }

    public void setPhoneAmount(int phoneAmount) { this.phoneAmount = phoneAmount; }

    public String getNameStock() { return nameStock; }

    public void setNameStock(String nameStock) { this.nameStock = nameStock; }

    public String getNamePhone() {return namePhone; }

    public void setNamePhone(String namePhone) { this.namePhone = namePhone; }
}

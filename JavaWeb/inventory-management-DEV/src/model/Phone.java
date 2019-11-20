package model;

public class Phone {
    private int idPhone;
    private String name;
    private int amount;
    private String information;
    private String image;
    private int idBrand;
    private String brandName;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String createBy;
    private String createDate;

    public Phone() {
    }

    public Phone(int idPhone, String name, int amount, String information, String image, int idBrand, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idPhone = idPhone;
        this.name = name;
        this.amount = amount;
        this.information = information;
        this.image = image;
        this.idBrand = idBrand;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public Phone(int idPhone, String name, int amount, String information, String image, String brandName, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idPhone = idPhone;
        this.name = name;
        this.amount = amount;
        this.information = information;
        this.image = image;
        this.brandName = brandName;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }
}

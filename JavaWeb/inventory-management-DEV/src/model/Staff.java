package model;

public class Staff {
    private int idStaff;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String gender;
    private String userName;
    private String pass;
    private String deleteBy;
    private String deleteDate;
    private String modifyBy;
    private String modifyDate;
    private String createBy;
    private String createDate;

    //create
    public Staff(String name,String userName, int age, String address, String phoneNumber,String gender ,String createBy) {
        this.name = name;
        this.userName =userName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createBy = createBy;
    }


    public Staff(int idStaff, String name, int age, String address, String phoneNumber, String gender, String createBy, String createDate) {
        this.idStaff = idStaff;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public Staff(int idStaff, String name,String pass,int age, String address, String phoneNumber, String gender, String deleteBy, String deleteDate, String modifyBy, String modifyDate, String createBy, String createDate) {
        this.idStaff = idStaff;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }
    // dang nhap
    public Staff(Integer idStaff, String name, Integer age, String address, String phoneNumber, String gender, String createBy, String createDate, String userName, String pass) {
        this.idStaff = idStaff;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createBy = createBy;
        this.createDate = createDate;
        this.userName = userName;
        this.pass = pass;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

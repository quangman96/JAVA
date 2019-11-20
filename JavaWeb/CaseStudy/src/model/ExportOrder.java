//package model;
//
//public class ExportOrder {
//    private int idExportOrder;
//    private String name;
//    private String deleteBy;
//    private String deleteDate;
//    private String createBy;
//    private String createDate;
//    private String modifyBy;
//    private String modifyDate;
//    public ExportOrder() {
//    }
//
//    public ExportOrder(int idExportOrder, String name, String deleteBy, String deleteDate, String createBy, String createDate, String modifyBy, String modifyDate) {
//        this.idExportOrder = idExportOrder;
//        this.name = name;
//        this.deleteBy = deleteBy;
//        this.deleteDate = deleteDate;
//        this.createBy = createBy;
//        this.createDate = createDate;
//        this.modifyBy = modifyBy;
//        this.modifyDate = modifyDate;
//    }
//    public ExportOrder(int idExportOrder, String name, String modifyBy, String modifyDate, String createBy, String createDate) {
//        this.idExportOrder = idExportOrder;
//        this.name = name;
//        this.modifyBy = modifyBy;
//        this.modifyDate = modifyDate;
//        this.createBy = createBy;
//        this.createDate = createDate;
//    }
//
//    public int getIdExportOrder() {
//        return idExportOrder;
//    }
//
//    public void setIdExportOrder(int idExportOrder) {
//        this.idExportOrder = idExportOrder;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDeleteBy() {
//        return deleteBy;
//    }
//
//    public void setDeleteBy(String deleteBy) {
//        this.deleteBy = deleteBy;
//    }
//
//    public String getDeleteDate() {
//        return deleteDate;
//    }
//
//    public void setDeleteDate(String deleteDate) {
//        this.deleteDate = deleteDate;
//    }
//
//    public String getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(String createBy) {
//        this.createBy = createBy;
//    }
//
//    public String getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(String createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getModifyBy() {
//        return modifyBy;
//    }
//
//    public void setModifyBy(String modifyBy) {
//        this.modifyBy = modifyBy;
//    }
//
//    public String getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(String modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//}
package model;

public class ExportOrder {
    private int idExportOrder;
    private int idStore;
    private int idStock;
    private int idStaff;
    private int idPhone;
    private String nameStore;
    private String nameStock;
    private String nameStaff;
    private String namePhone;
    private int phoneAmount;

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public int getPhoneAmount() {
        return phoneAmount;
    }

    public void setPhoneAmount(int phoneAmount) {
        this.phoneAmount = phoneAmount;
    }

    private String name;
    private String deleteBy;
    private String deleteDate;
    private String createBy;
    private String createDate;
    private String modifyBy;
    private String modifyDate;
    public ExportOrder() {
    }

    public ExportOrder(String nameStore, String nameStock, String nameStaff, String namePhone, int phoneAmount, String name) {
//        this.idExportOrder = idExportOrder;
        this.nameStore = nameStore;
        this.nameStock = nameStock;
        this.nameStaff = nameStaff;
        this.namePhone = namePhone;
        this.phoneAmount = phoneAmount;
        this.name = name;
    }

    public ExportOrder(int idExportOrder, String name, String deleteBy, String deleteDate, String createBy, String createDate, String modifyBy, String modifyDate) {
        this.idExportOrder = idExportOrder;
        this.name = name;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public ExportOrder(int idStore, int idStock, int idStaff, String name, String createBy) {
        this.idStore = idStore;
        this.idStock = idStock;
        this.idStaff = idStaff;
        this.name = name;
        this.createBy = createBy;
    }

    public ExportOrder(int idExportOrder, String nameStore, String nameStock, String nameStaff, String name, String createBy, String createDate, String modifyBy, String modifyDate) {
        this.idExportOrder = idExportOrder;
        this.nameStore = nameStore;
        this.nameStock = nameStock;
        this.nameStaff = nameStaff;
        this.name = name;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }
    public ExportOrder(int idExportOrder, int phoneAmount, String nameStore, String nameStock, String nameStaff, String namePhone, String name, String deleteBy, String deleteDate, String createBy, String createDate, String modifyBy, String modifyDate) {
        this.idExportOrder = idExportOrder;
        this.phoneAmount = phoneAmount;
        this.nameStore = nameStore;
        this.nameStock = nameStock;
        this.nameStaff = nameStaff;
        this.namePhone = namePhone;
        this.name = name;
        this.deleteBy = deleteBy;
        this.deleteDate = deleteDate;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public int getIdExportOrder() {
        return idExportOrder;
    }

    public void setIdExportOrder(int idExportOrder) {
        this.idExportOrder = idExportOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
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
}


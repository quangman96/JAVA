package model;

public class ExportOrder {
    private int idExportOrder;
    private String name;
    private String deleteBy;
    private String deleteDate;
    private String createBy;
    private String createDate;
    private String modifyBy;
    private String modifyDate;
    public ExportOrder() {
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
}

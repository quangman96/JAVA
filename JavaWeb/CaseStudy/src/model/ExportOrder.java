package model;

public class ExportOrder {
    private int idExportOrder;
    private String name;
    private String exportDate;
    private int isDelete;
    private String deleteBy;
    private String deleteDay;
    private String modifyBy;
    private String modifyDay;
    private String createBy;
    private String createDay;

    public ExportOrder(){
    }

    public ExportOrder(int idExportOrder, String name, String exportDate, int isDelete, String createBy){
        this.idExportOrder = idExportOrder;
        this.name = name;
        this.exportDate = exportDate;
        this.isDelete = isDelete;
        this.createBy = createBy;
    }
    public ExportOrder(String name, String createBy) {
//        this.idExportOrder = idExportOrder;
        this.name = name;
        this.createBy = createBy;
    }
    public ExportOrder(int idExportOrder, String name, String createBy, String createDate) {
        this.idExportOrder = idExportOrder;
        this.name = name;
        this.createBy = createBy;
        this.createDay = createDate;
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

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public void setCreateDay(String createDay) { this.createDay = createDay;}

    public String getCreateDay() { return createDay; }
}

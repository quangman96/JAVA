package oop.baitap2;

public class License {
    private boolean giayphep = false;
    private int ngaycap;
    private int ngayhethan;
    public License(){
    }
    public License(boolean giayphep){
    }
    public License(boolean giayphep, int ngaycap, int ngayhethan){
        this.giayphep = giayphep;
        this.ngaycap = ngaycap;
        this.ngayhethan = ngayhethan;
    }

    public boolean isGiayphep() {
        return giayphep;
    }

    public void setGiayphep(boolean giayphep) {
        this.giayphep = giayphep;
    }

    public int getNgaycap() {
        return ngaycap;
    }

    public void setNgaycap(int ngaycap) {
        this.ngaycap = ngaycap;
    }

    public int getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(int ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String toString(){
        if(giayphep == false) {
            return "Con cho khong co giap phep.";
        }
        else {
            return "Con cho co giap phep. Su dung tu : "+this.ngaycap+
                    " den: "+this.ngayhethan;
        }
    }
}

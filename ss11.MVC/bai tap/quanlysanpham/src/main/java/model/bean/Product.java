package model.bean;

public class Product {
    private int id;
    private String ten;
    private String gia;
    private String mota;
    private String nhasx;

    public Product() {
    }

    public Product(int id, String ten, String gia, String mota, String nhasx) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
        this.nhasx = nhasx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNhasx() {
        return nhasx;
    }

    public void setNhasx(String nhasx) {
        this.nhasx = nhasx;
    }
}

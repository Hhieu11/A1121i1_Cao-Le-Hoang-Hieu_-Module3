public class khachhang {
    private String name;
    private String birthday;
    private String diachi;
    private String hinhanh;

    public khachhang() {
    }

    public khachhang(String name, String birthday, String diachi, String hinhanh) {
        this.name = name;
        this.birthday = birthday;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String isDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}

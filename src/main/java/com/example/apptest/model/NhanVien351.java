package com.example.apptest.model;

public class NhanVien351 extends ThanhVien351{
    private String vaitro;
    private String hinhanh;
    public NhanVien351() {
        super();
    }

    public NhanVien351(int id, String username, String password, String hoten,
                       java.sql.Date ngaysinh, String diachi, String email,
                       String sodienthoai, String vaitro, String hinhanh) {
        super(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai);
        this.vaitro = vaitro;
        this.hinhanh = hinhanh;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @Override
    public String toString() {
        return "NhanVien351{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", hoten='" + getHoten() + '\'' +
                ", ngaysinh=" + getNgaysinh() +
                ", diachi='" + getDiachi() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", sodienthoai='" + getSodienthoai() + '\'' +
                ", vaitro='" + vaitro + '\'' +
                ", hinhanh='" + hinhanh + '\'' +
                '}';
    }
}

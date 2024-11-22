package com.example.apptest.model;

import java.sql.Date;

public class BanDoc351 extends ThanhVien351 {
    private String ghiChu;
    private String maSV;

    public BanDoc351() {}

    public BanDoc351(int id, String username, String password, String hoten, Date ngaysinh, String diachi, String email, String sodienthoai, String ghiChu, String maSV) {
        super(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai); // Gọi constructor của lớp cha
        this.ghiChu = ghiChu;
        this.maSV = maSV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    @Override
    public String toString() {
        return "BanDoc351{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", hoten='" + getHoten() + '\'' +
                ", ngaysinh=" + getNgaysinh() +
                ", diachi='" + getDiachi() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", sodienthoai='" + getSodienthoai() + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", maSV='" + maSV + '\'' +
                '}';
    }
}

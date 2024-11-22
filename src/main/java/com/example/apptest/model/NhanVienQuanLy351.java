package com.example.apptest.model;

import java.sql.Date;

public class NhanVienQuanLy351 extends NhanVien351 {
    private String phongban;
    private String quyenhan;

    public NhanVienQuanLy351() {
        super();
    }

    public NhanVienQuanLy351(int id, String username, String password, String hoten, Date ngaysinh,
                             String diachi, String email, String sodienthoai, String vaitro,
                             String hinhanh, String phongban, String quyenhan) {
        super(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai, vaitro, hinhanh);
        this.phongban = phongban;
        this.quyenhan = quyenhan;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public String getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(String quyenhan) {
        this.quyenhan = quyenhan;
    }

    @Override
    public String toString() {
        return "NhanVienQuanLy351{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", hoten='" + getHoten() + '\'' +
                ", ngaysinh=" + getNgaysinh() +
                ", diachi='" + getDiachi() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", sodienthoai='" + getSodienthoai() + '\'' +
                ", vaitro='" + getVaitro() + '\'' +
                ", hinhanh='" + getHinhanh() + '\'' +
                ", phongban='" + phongban + '\'' +
                ", quyenhan='" + quyenhan + '\'' +
                '}';
    }
}

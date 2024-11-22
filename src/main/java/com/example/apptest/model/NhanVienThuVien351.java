package com.example.apptest.model;

import java.sql.Date;

public class NhanVienThuVien351 extends NhanVien351 {
    private String caTruc;
    private String khuVucPhuTrach;

    public NhanVienThuVien351() {
        super();
    }

    public NhanVienThuVien351(int id, String username, String password, String hoten, Date ngaysinh,
                              String diachi, String email, String sodienthoai, String vaitro,
                              String hinhanh, String caTruc, String khuVucPhuTrach) {
        super(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai, vaitro, hinhanh);
        this.caTruc = caTruc;
        this.khuVucPhuTrach = khuVucPhuTrach;
    }

    public String getCaTruc() {
        return caTruc;
    }

    public void setCaTruc(String caTruc) {
        this.caTruc = caTruc;
    }

    public String getKhuVucPhuTrach() {
        return khuVucPhuTrach;
    }

    public void setKhuVucPhuTrach(String khuVucPhuTrach) {
        this.khuVucPhuTrach = khuVucPhuTrach;
    }

    @Override
    public String toString() {
        return "NhanVienThuVien351{" +
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
                ", caTruc='" + caTruc + '\'' +
                ", khuVucPhuTrach='" + khuVucPhuTrach + '\'' +
                '}';
    }
}


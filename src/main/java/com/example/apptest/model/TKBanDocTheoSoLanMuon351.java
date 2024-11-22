package com.example.apptest.model;

import java.sql.Date;

public class TKBanDocTheoSoLanMuon351 extends BanDoc351 {
    private int tongSoLanMuon;

    public TKBanDocTheoSoLanMuon351() {
        super();
    }

    public TKBanDocTheoSoLanMuon351(int id, String username, String password, String hoten, Date ngaysinh,
                                    String diachi, String email, String sodienthoai, String ghiChu,
                                    String maSV, int tongSoLanMuon) {
        super(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai, ghiChu, maSV);
        this.tongSoLanMuon = tongSoLanMuon;
    }

    public int getTongSoLanMuon() {
        return tongSoLanMuon;
    }

    public void setTongSoLanMuon(int tongSoLanMuon) {
        this.tongSoLanMuon = tongSoLanMuon;
    }

    @Override
    public String toString() {
        return "TKBanDocTheoSoLanMuon351{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", hoten='" + getHoten() + '\'' +
                ", ngaysinh=" + getNgaysinh() +
                ", diachi='" + getDiachi() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", sodienthoai='" + getSodienthoai() + '\'' +
                ", ghiChu='" + getGhiChu() + '\'' +
                ", maSV='" + getMaSV() + '\'' +
                ", tongSoLanMuon=" + tongSoLanMuon +
                '}';
    }
}

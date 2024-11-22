package com.example.apptest.model;

import java.sql.Date;
import java.util.List;

public class PhieuMuon351 {
    private int id;
    private Date ngaymuon;
    private Date ngaytradukien;
    private String trangthai;
    private BanDoc351 banDoc;
    private NhanVienThuVien351 thuVien;

    private List<TaiLieuDaMuon351> taiLieuDaMuon351;

    private int tongSoluongMuon;

    public int getTongSoluongMuon() {
        return tongSoluongMuon;
    }

    public void setTongSoluongMuon(int tongSoluongMuon) {
        this.tongSoluongMuon = tongSoluongMuon;
    }

    public List<TaiLieuDaMuon351> getTaiLieuDaMuon351() {
        return taiLieuDaMuon351;
    }

    public void setTaiLieuDaMuon351(List<TaiLieuDaMuon351> taiLieuDaMuon351) {
        this.taiLieuDaMuon351 = taiLieuDaMuon351;
    }

    public BanDoc351 getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc351 banDoc) {
        this.banDoc = banDoc;
    }

    public NhanVienThuVien351 getThuVien() {
        return thuVien;
    }

    public void setThuVien(NhanVienThuVien351 thuVien) {
        this.thuVien = thuVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgaytradukien() {
        return ngaytradukien;
    }

    public void setNgaytradukien(Date ngaytradukien) {
        this.ngaytradukien = ngaytradukien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}

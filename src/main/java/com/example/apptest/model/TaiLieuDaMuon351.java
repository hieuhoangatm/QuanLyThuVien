package com.example.apptest.model;

import java.time.Year;

public class TaiLieuDaMuon351 extends TaiLieu351 {

    private int idPhieuMuon;
    private int soluongMuon;

    public TaiLieuDaMuon351() {}

    public TaiLieuDaMuon351(int id, String tentailieu, String tacgia, int soluongcosan, Year namxuatban, TheLoai351 theLoai351, int idPhieuMuon, int soluongMuon) {
        super(id, tentailieu, tacgia, soluongcosan, namxuatban, theLoai351);
        this.idPhieuMuon = idPhieuMuon;
        this.soluongMuon = soluongMuon;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public int getSoluongMuon() {
        return soluongMuon;
    }

    public void setSoluongMuon(int soluongMuon) {
        this.soluongMuon = soluongMuon;
    }

    // Thêm phương thức setTaiLieu vào lớp này nếu cần
    public void setTaiLieu(TaiLieu351 taiLieu) {
        // Thiết lập các thuộc tính từ đối tượng taiLieu vào đối tượng này nếu cần
        setId(taiLieu.getId());
        setTentailieu(taiLieu.getTentailieu());
        setTacgia(taiLieu.getTacgia());
        setSoluongcosan(taiLieu.getSoluongcosan());
        setNamxuatban(taiLieu.getNamxuatban());
        setTheLoai351(taiLieu.getTheLoai351());
    }

    @Override
    public String toString() {
        return "TaiLieuDaMuon351{" +
                "idPhieuMuon=" + idPhieuMuon +
                ", soluongMuon=" + soluongMuon +
                "} " + super.toString();
    }
}

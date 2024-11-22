package com.example.apptest.model;

import java.time.Year;


public class TaiLieu351 {
    private int id;
    private String tentailieu;

    private String tacgia;

    private int soluongcosan;

    private Year namxuatban;

    private TheLoai351 theLoai351;

    public TaiLieu351(){};

    public TaiLieu351(int id, String tentailieu, String tacgia, int soluongcosan, Year namxuatban, TheLoai351 theLoai351) {
        this.id = id;
        this.tentailieu = tentailieu;
        this.tacgia = tacgia;
        this.soluongcosan = soluongcosan;
        this.namxuatban = namxuatban;
        this.theLoai351 = theLoai351;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentailieu() {
        return tentailieu;
    }

    public void setTentailieu(String tentailieu) {
        this.tentailieu = tentailieu;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getSoluongcosan() {
        return soluongcosan;
    }

    public void setSoluongcosan(int soluongcosan) {
        this.soluongcosan = soluongcosan;
    }

    public Year getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(Year namxuatban) {
        this.namxuatban = namxuatban;
    }

    public TheLoai351 getTheLoai351() {
        return theLoai351;
    }

    public void setTheLoai351(TheLoai351 theLoai351) {
        this.theLoai351 = theLoai351;
    }

    @Override
    public String toString() {
        return "TaiLieu351{" +
                "id=" + id +
                ", tentailieu='" + tentailieu + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", soluongcosan=" + soluongcosan +
                ", namxuatban=" + namxuatban +
                ", theLoai351=" + theLoai351 +
                '}';
    }
}

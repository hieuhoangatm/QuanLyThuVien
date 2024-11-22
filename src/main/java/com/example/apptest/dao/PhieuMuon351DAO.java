package com.example.apptest.dao;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.example.apptest.model.*;

public class PhieuMuon351DAO {

    private Connection connection;

    public PhieuMuon351DAO() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PhieuMuon351> getDSPhieuMuonCuaBanDoc(int idBanDoc) {
        List<PhieuMuon351> phieuMuonList = new ArrayList<>();
        String query =
                "SELECT " +
                        "    pm.id AS phieuMuonId, " +
                        "    pm.ngaymuon, " +
                        "    pm.ngaytradukien, " +
                        "    pm.trangthai, " +
                        "    bd.id AS banDocId, " +
                        "    tvbd.username AS banDocUsername, " +
                        "    tvbd.hoten AS banDocHoTen, " +
                        "    tvbd.email AS banDocEmail, " +
                        "    tvbd.diachi AS banDocDiaChi, " +
                        "    tvbd.sodienthoai AS banDocSoDienThoai, " +
                        "    nvtv.id AS thuVienId, " +
                        "    tvnv.hoten AS thuVienHoTen, " +
                        "    tvnv.email AS thuVienEmail, " +
                        "    tvnv.diachi AS thuVienDiaChi, " +
                        "    nvtv.catruc, " +
                        "    nvtv.khuvucphutrach, " +
                        "    SUM(tldm.soluongmuon) AS tongSoLuongMuon " +  // Tổng số lượng mượn
                        "FROM tblPhieuMuon351 pm " +
                        "JOIN tblBanDoc351 bd ON pm.idBanDoc = bd.id " +
                        "JOIN tblThanhVien351 tvbd ON bd.id = tvbd.id " +
                        "JOIN tblNhanVienThuVien351 nvtv ON pm.idThuVien = nvtv.id " +
                        "JOIN tblNhanVien351 nv ON nvtv.id = nv.id " +
                        "JOIN tblThanhVien351 tvnv ON nv.id = tvnv.id " +
                        "LEFT JOIN tblTaiLieuDaMuon351 tldm ON pm.id = tldm.idPhieuMuon " +
                        "WHERE bd.id = ? " +
                        "GROUP BY pm.id, bd.id, nvtv.id";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idBanDoc);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhieuMuon351 phieuMuon = new PhieuMuon351();
                phieuMuon.setId(rs.getInt("phieuMuonId"));
                phieuMuon.setNgaymuon(rs.getDate("ngaymuon"));
                phieuMuon.setNgaytradukien(rs.getDate("ngaytradukien"));
                phieuMuon.setTrangthai(rs.getString("trangthai"));

                // Thông tin bạn đọc
                BanDoc351 banDoc = new BanDoc351();
                banDoc.setId(rs.getInt("banDocId"));
                banDoc.setHoten(rs.getString("banDocHoTen"));
                banDoc.setEmail(rs.getString("banDocEmail"));
                banDoc.setDiachi(rs.getString("banDocDiaChi"));
                banDoc.setSodienthoai(rs.getString("banDocSoDienThoai"));
                phieuMuon.setBanDoc(banDoc);

                // Thông tin nhân viên thư viện
                NhanVienThuVien351 thuVien = new NhanVienThuVien351();
                thuVien.setId(rs.getInt("thuVienId"));
                thuVien.setHoten(rs.getString("thuVienHoTen"));
                thuVien.setEmail(rs.getString("thuVienEmail"));
                thuVien.setDiachi(rs.getString("thuVienDiaChi"));
                thuVien.setCaTruc(rs.getString("catruc"));
                thuVien.setKhuVucPhuTrach(rs.getString("khuvucphutrach"));
                phieuMuon.setThuVien(thuVien);

                // Cập nhật tổng số lượng mượn
                phieuMuon.setTongSoluongMuon(rs.getInt("tongSoLuongMuon"));

                phieuMuonList.add(phieuMuon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phieuMuonList;
    }

public PhieuMuon351 getChiTietPhieuMuon(int idPhieuMuon) {
    PhieuMuon351 phieuMuon = null;
    String query =
            "SELECT " +
                    "    pm.id AS phieuMuonId, " +
                    "    pm.ngaymuon, " +
                    "    pm.ngaytradukien, " +
                    "    pm.trangthai, " +
                    "    bd.id AS banDocId, " +
                    "    tvbd.hoten AS banDocHoTen, " +
                    "    tvbd.email AS banDocEmail, " +
                    "    tvbd.ngaysinh AS banDocNgaySinh, " +
                    "    tvbd.diachi AS banDocDiaChi, " +
                    "    tvbd.sodienthoai AS banDocSoDienThoai, " +
                    "    nvtv.id AS thuVienId, " +
                    "    tvnv.hoten AS thuVienHoTen, " +
                    "    tvnv.email AS thuVienEmail, " +
                    "    tvnv.diachi AS thuVienDiaChi, " +
                    "    nvtv.catruc, " +
                    "    nvtv.khuvucphutrach, " +
                    "    tl.id AS taiLieuId, " +
                    "    tl.tentailieu, " +
                    "    tl.tacgia, " +
                    "    tl.namxuatban, "+
                    "    COALESCE(SUM(tldm.soluongmuon), 0) AS tongSoLuongMuon, " +
                    "    tldm.soluongmuon " +  // Thêm soluongmuon
                    "FROM tblPhieuMuon351 pm " +
                    "JOIN tblBanDoc351 bd ON pm.idBanDoc = bd.id " +
                    "JOIN tblThanhVien351 tvbd ON bd.id = tvbd.id " +
                    "JOIN tblNhanVienThuVien351 nvtv ON pm.idThuVien = nvtv.id " +
                    "JOIN tblNhanVien351 nv ON nvtv.id = nv.id " +
                    "JOIN tblThanhVien351 tvnv ON nv.id = tvnv.id " +
                    "LEFT JOIN tblTaiLieuDaMuon351 tldm ON pm.id = tldm.idPhieuMuon " +
                    "LEFT JOIN tblTaiLieu351 tl ON tldm.idTaiLieu = tl.id " +
                    "WHERE pm.id = ? " +
                    "GROUP BY pm.id, bd.id, nvtv.id, tl.id, tldm.soluongmuon";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setInt(1, idPhieuMuon);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                phieuMuon = new PhieuMuon351();
                phieuMuon.setId(rs.getInt("phieuMuonId"));
                phieuMuon.setNgaymuon(rs.getDate("ngaymuon"));
                phieuMuon.setNgaytradukien(rs.getDate("ngaytradukien"));
                phieuMuon.setTrangthai(rs.getString("trangthai"));

                // Thông tin bạn đọc
                BanDoc351 banDoc = new BanDoc351();
                banDoc.setId(rs.getInt("banDocId"));
                banDoc.setHoten(rs.getString("banDocHoTen"));
                banDoc.setEmail(rs.getString("banDocEmail"));
                banDoc.setDiachi(rs.getString("banDocDiaChi"));
                banDoc.setSodienthoai(rs.getString("banDocSoDienThoai"));
                banDoc.setNgaysinh(rs.getDate("banDocNgaySinh"));
                phieuMuon.setBanDoc(banDoc);

                // Thông tin nhân viên thư viện
                NhanVienThuVien351 thuVien = new NhanVienThuVien351();
                thuVien.setId(rs.getInt("thuVienId"));
                thuVien.setHoten(rs.getString("thuVienHoTen"));
                thuVien.setEmail(rs.getString("thuVienEmail"));
                thuVien.setDiachi(rs.getString("thuVienDiaChi"));
                thuVien.setCaTruc(rs.getString("catruc"));
                thuVien.setKhuVucPhuTrach(rs.getString("khuvucphutrach"));
                phieuMuon.setThuVien(thuVien);

                // Cập nhật tổng số lượng mượn
                phieuMuon.setTongSoluongMuon(rs.getInt("tongSoLuongMuon"));

                // Tạo danh sách tài liệu đã mượn
                List<TaiLieuDaMuon351> taiLieuDaMuonList = new ArrayList<>();
                do {
                    TaiLieuDaMuon351 taiLieuDaMuon = new TaiLieuDaMuon351();
                    TaiLieu351 taiLieu = new TaiLieu351();
                    taiLieu.setId(rs.getInt("taiLieuId"));
                    taiLieu.setTentailieu(rs.getString("tentailieu"));
                    taiLieu.setTacgia(rs.getString("tacgia"));
                    taiLieu.setNamxuatban(Year.of(rs.getInt("namxuatban")));
                    taiLieuDaMuon.setTaiLieu(taiLieu);
                    taiLieuDaMuon.setSoluongMuon(rs.getInt("soluongmuon"));

                    taiLieuDaMuonList.add(taiLieuDaMuon);
                } while (rs.next());

                phieuMuon.setTaiLieuDaMuon351(taiLieuDaMuonList);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return phieuMuon;
}

}


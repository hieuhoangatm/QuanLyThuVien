package com.example.apptest.dao;

import com.example.apptest.model.TKBanDocTheoSoLanMuon351;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.example.apptest.model.TKBanDocTheoSoLanMuon351;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TKBanDocTheoSoLanMuon351DAO {
    public List<TKBanDocTheoSoLanMuon351> getTKBanDocTheoSoLanMuon(Date startDate, Date endDate) throws SQLException {
        String query = "SELECT b.id, t.username, t.hoten, t.sodienthoai, t.email, COUNT(p.id) AS tongSoLanMuon " +
                "FROM tblBanDoc351 b " +
                "JOIN tblThanhVien351 t ON b.id = t.id " +
                "LEFT JOIN tblPhieuMuon351 p ON b.id = p.idBanDoc " +
                "WHERE p.ngaymuon BETWEEN ? AND ? " + // Lọc theo ngày
                "GROUP BY b.id, t.username, t.hoten, t.sodienthoai, t.email " +
                "HAVING COUNT(p.id) > 0 " + // Lọc ra những bạn đọc có số lần mượn > 0
                "ORDER BY tongSoLanMuon DESC"; // Sắp xếp theo số lần mượn giảm dần

        List<TKBanDocTheoSoLanMuon351> thongKeList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Gán giá trị cho tham số truy vấn
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TKBanDocTheoSoLanMuon351 thongKe = new TKBanDocTheoSoLanMuon351();
                    thongKe.setId(rs.getInt("id"));
                    thongKe.setUsername(rs.getString("username"));
                    thongKe.setHoten(rs.getString("hoten"));
                    thongKe.setSodienthoai(rs.getString("sodienthoai"));
                    thongKe.setEmail(rs.getString("email"));
                    thongKe.setTongSoLanMuon(rs.getInt("tongSoLanMuon"));
                    thongKeList.add(thongKe);
                }
            }
        }

        return thongKeList;
    }
}

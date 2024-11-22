package com.example.apptest.dao;


import com.example.apptest.model.ThanhVien351;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ThanhVien351DAO {
    private static final String INSERT_SQL = "INSERT INTO tblThanhVien351 (username, password, hoten, ngaysinh, diachi, email, sodienthoai) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM tblThanhVien351 WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM tblThanhVien351";
    private static final String UPDATE_SQL = "UPDATE tblThanhVien351 SET username = ?, password = ?, hoten = ?, ngaysinh = ?, diachi = ?, email = ?, sodienthoai = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM tblThanhVien351 WHERE id = ?";

    // Thêm thành viên
    public void insertThanhVien(ThanhVien351 thanhVien) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, thanhVien.getUsername());
            preparedStatement.setString(2, thanhVien.getPassword());
            preparedStatement.setString(3, thanhVien.getHoten());
            preparedStatement.setString(5, thanhVien.getDiachi());
            preparedStatement.setString(6, thanhVien.getEmail());
            preparedStatement.setString(7, thanhVien.getSodienthoai());
            preparedStatement.executeUpdate();
        }
    }

    // Lấy thành viên theo ID
    public ThanhVien351 selectThanhVien(int id) {
        ThanhVien351 thanhVien = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                thanhVien = new ThanhVien351();
                thanhVien.setId(rs.getInt("id"));
                thanhVien.setUsername(rs.getString("username"));
                thanhVien.setPassword(rs.getString("password"));
                thanhVien.setHoten(rs.getString("hoten"));
                thanhVien.setNgaysinh(rs.getDate("ngaysinh"));
                thanhVien.setDiachi(rs.getString("diachi"));
                thanhVien.setEmail(rs.getString("email"));
                thanhVien.setSodienthoai(rs.getString("sodienthoai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thanhVien;
    }

    // Lấy danh sách tất cả thành viên
    public List<ThanhVien351> selectAllThanhVien() {
        List<ThanhVien351> thanhViens = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThanhVien351 thanhVien = new ThanhVien351();
                thanhVien.setId(rs.getInt("id"));
                thanhVien.setUsername(rs.getString("username"));
                thanhVien.setPassword(rs.getString("password"));
                thanhVien.setHoten(rs.getString("hoten"));
                thanhVien.setNgaysinh(rs.getDate("ngaysinh"));
                thanhVien.setDiachi(rs.getString("diachi"));
                thanhVien.setEmail(rs.getString("email"));
                thanhVien.setSodienthoai(rs.getString("sodienthoai"));
                thanhViens.add(thanhVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thanhViens;
    }

    public boolean updateThanhVien(ThanhVien351 thanhVien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, thanhVien.getUsername());
            preparedStatement.setString(2, thanhVien.getPassword());
            preparedStatement.setString(3, thanhVien.getHoten());
            preparedStatement.setDate(4,thanhVien.getNgaysinh());
            preparedStatement.setString(5, thanhVien.getDiachi());
            preparedStatement.setString(6, thanhVien.getEmail());
            preparedStatement.setString(7, thanhVien.getSodienthoai());
            preparedStatement.setInt(8, thanhVien.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteThanhVien(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}

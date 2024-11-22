package com.example.apptest.dao;

import com.example.apptest.model.TaiLieu351;
import com.example.apptest.model.TheLoai351;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TaiLieu351DAO {
    public List<TaiLieu351> getDSTaiLieuByName(String name) throws SQLException {
        List<TaiLieu351> taiLieuList = new ArrayList<>();
        String query = "SELECT t.id, t.tentailieu, t.tacgia " +
                "FROM tblTaiLieu351 t " +
                "WHERE t.tentailieu LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenTaiLieu = resultSet.getString("tentailieu");
                String tacGia = resultSet.getString("tacgia");

                TaiLieu351 taiLieu = new TaiLieu351();
                taiLieu.setId(id);
                taiLieu.setTentailieu(tenTaiLieu);
                taiLieu.setTacgia(tacGia);

                taiLieuList.add(taiLieu);
            }

        } catch (SQLException e) {
            System.out.println("Error while searching for documents: " + e.getMessage());
            throw e;
        }

        return taiLieuList;
    }

    public TaiLieu351 getChiTietTaiLieu(int id) throws SQLException {
        TaiLieu351 taiLieu = null;
        String query = "SELECT t.id, t.tentailieu, t.tacgia, t.soluongcosan, t.namxuatban, t.idTheLoai, " +
                "tl.tenTheLoai " +
                "FROM tblTaiLieu351 t " +
                "JOIN tblTheLoai351 tl ON t.idTheLoai = tl.id " +
                "WHERE t.id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int taiLieuId = resultSet.getInt("id");
                String tenTaiLieu = resultSet.getString("tentailieu");
                String tacGia = resultSet.getString("tacgia");
                int soLuongCoSan = resultSet.getInt("soluongcosan");
                Year namXuatBan = Year.of(resultSet.getInt("namxuatban"));
                int idTheLoai = resultSet.getInt("idTheLoai");
                String tenTheLoai = resultSet.getString("tenTheLoai");

                TheLoai351 theLoai = new TheLoai351(idTheLoai, tenTheLoai);

                taiLieu = new TaiLieu351(taiLieuId, tenTaiLieu, tacGia, soLuongCoSan, namXuatBan, theLoai);
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching document details by ID: " + e.getMessage());
            throw e;
        }

        return taiLieu;
    }


}

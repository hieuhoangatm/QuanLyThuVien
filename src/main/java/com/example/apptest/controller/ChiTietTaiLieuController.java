package com.example.apptest.controller;

import com.example.apptest.dao.TaiLieu351DAO;
import com.example.apptest.model.TaiLieu351;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/chitiettailieuu")
public class ChiTietTaiLieuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số id từ URL
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.getWriter().println("ID tài liệu không hợp lệ.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam); // Chuyển đổi tham số id thành số nguyên
            TaiLieu351DAO dao = new TaiLieu351DAO();
            TaiLieu351 taiLieu = dao.getChiTietTaiLieu(id); // Gọi DAO để lấy chi tiết tài liệu

            if (taiLieu != null) {
                // Đặt đối tượng tài liệu vào request
                request.setAttribute("taiLieu", taiLieu);

                // Chuyển tiếp tới trang JSP hiển thị chi tiết tài liệu
                request.getRequestDispatcher("/GDChiTietTaiLieu351.jsp").forward(request, response);
            } else {
                // Nếu không tìm thấy tài liệu, hiển thị thông báo
                response.getWriter().println("Không tìm thấy tài liệu với ID: " + id);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("ID không hợp lệ: " + idParam);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi truy vấn cơ sở dữ liệu: " + e.getMessage());
        }
    }
}

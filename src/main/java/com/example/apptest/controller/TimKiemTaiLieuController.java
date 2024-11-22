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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/test")
public class TimKiemTaiLieuController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(TimKiemTaiLieuController.class.getName());
    private TaiLieu351DAO taiLieuDAO;

    @Override
    public void init() throws ServletException{
        super.init();
        taiLieuDAO = new TaiLieu351DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        if (query == null || query.trim().isEmpty()) {
            // Nếu query rỗng, có thể hiển thị một thông báo hoặc thực hiện hành động khác
            request.setAttribute("errorMessage", "Vui lòng nhập tên tài liệu cần tìm.");
            request.getRequestDispatcher("/gdTimTaiLieu351.jsp").forward(request, response);
            return;
        }

        try {
            // Tìm kiếm tài liệu theo tên
            List<TaiLieu351> taiLieuList = taiLieuDAO.getDSTaiLieuByName(query);

            // Đặt kết quả vào request để hiển thị trong JSP
            if (taiLieuList.isEmpty()) {
                request.setAttribute("errorMessage", "Không tìm thấy tài liệu nào khớp với từ khóa.");
            } else {
                request.setAttribute("resultList", taiLieuList);
            }

            // Chuyển hướng tới trang JSP để hiển thị kết quả
            request.getRequestDispatcher("/gdTimTaiLieu351.jsp").forward(request, response);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error while searching documents: " + e.getMessage(), e);
            request.setAttribute("errorMessage", "Có lỗi khi tìm kiếm tài liệu.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

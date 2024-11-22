package com.example.apptest.controller;

import com.example.apptest.dao.ThanhVien351DAO;
import com.example.apptest.model.ThanhVien351;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "thanhvien", value = "/thanhvien")
public class ThanhVien351Controller extends HttpServlet {
    private ThanhVien351DAO thanhVienDAO;

    @Override
    public void init() throws ServletException {
        thanhVienDAO = new ThanhVien351DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertThanhVien(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateThanhVien(request, response);
                    break;
                case "delete":
                    deleteThanhVien(request, response);
                    break;
                default:
                    listThanhVien(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void listThanhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThanhVien351> listThanhVien = thanhVienDAO.selectAllThanhVien();
        request.setAttribute("listThanhVien", listThanhVien);
        request.getRequestDispatcher("thanhvien-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("thanhvien-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThanhVien351 existingThanhVien = thanhVienDAO.selectThanhVien(id);
        request.setAttribute("thanhVien", existingThanhVien);
        request.getRequestDispatcher("thanhvien-form.jsp").forward(request, response);
    }

    private void insertThanhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hoten = request.getParameter("hoten");
        Date ngaysinh = Date.valueOf(request.getParameter("ngaysinh"));
        String diachi = request.getParameter("diachi");
        String email = request.getParameter("email");
        String sodienthoai = request.getParameter("sodienthoai");

        ThanhVien351 thanhVien = new ThanhVien351(0, username, password, hoten, ngaysinh, diachi, email, sodienthoai);
        thanhVienDAO.insertThanhVien(thanhVien);
        response.sendRedirect("thanhvien");
    }

    private void updateThanhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hoten = request.getParameter("hoten");
        Date ngaysinh = Date.valueOf(request.getParameter("ngaysinh"));
        String diachi = request.getParameter("diachi");
        String email = request.getParameter("email");
        String sodienthoai = request.getParameter("sodienthoai");

        ThanhVien351 thanhVien = new ThanhVien351(id, username, password, hoten, ngaysinh, diachi, email, sodienthoai);
        thanhVienDAO.updateThanhVien(thanhVien);
        response.sendRedirect("thanhvien");
    }

    private void deleteThanhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        thanhVienDAO.deleteThanhVien(id);
        response.sendRedirect("thanhvien");
    }
}

package com.example.apptest.controller;

import com.example.apptest.dao.PhieuMuon351DAO;
import com.example.apptest.model.PhieuMuon351;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/chitietphieumuon")
public class ChiTietPhieuMuonController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PhieuMuon351DAO phieuMuon351DAO;

    @Override
    public void init() throws ServletException {
        super.init();
        phieuMuon351DAO = new PhieuMuon351DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idPhieuMuon = request.getParameter("id");
        int idPM = Integer.parseInt(idPhieuMuon);

        try {
            PhieuMuon351 phieuMuon = phieuMuon351DAO.getChiTietPhieuMuon(idPM);

            request.setAttribute("phieuMuon", phieuMuon);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/GDChiTietPhieuMuon351.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi lấy dữ liệu phiếu mượn.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}


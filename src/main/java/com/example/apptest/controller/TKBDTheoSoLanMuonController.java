package com.example.apptest.controller;

import com.example.apptest.dao.TKBanDocTheoSoLanMuon351DAO;
import com.example.apptest.model.TKBanDocTheoSoLanMuon351;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/thong-ke-ban-doc")
public class TKBDTheoSoLanMuonController extends HttpServlet {

    private final TKBanDocTheoSoLanMuon351DAO thongKeDAO = new TKBanDocTheoSoLanMuon351DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ngayBatDauStr = request.getParameter("ngayBatDau");
        String ngayKetThucStr = request.getParameter("ngayKetThuc");

        try {
            if (ngayBatDauStr == null || ngayBatDauStr.isEmpty() ||
                    ngayKetThucStr == null || ngayKetThucStr.isEmpty()) {
                throw new IllegalArgumentException("Ngày bắt đầu và ngày kết thúc không được để trống.");
            }

            Date ngayBatDau = convertToDate(ngayBatDauStr);
            Date ngayKetThuc = convertToDate(ngayKetThucStr);

            // Gọi DAO để lấy dữ liệu
            List<TKBanDocTheoSoLanMuon351> thongKeList = thongKeDAO.getTKBanDocTheoSoLanMuon(ngayBatDau, ngayKetThuc);

            // Gửi dữ liệu sang JSP
            request.setAttribute("thongKeList", thongKeList);
            request.setAttribute("ngayBatDau", ngayBatDauStr); // Trả lại chuỗi để hiển thị trong giao diện
            request.setAttribute("ngayKetThuc", ngayKetThucStr);

            // Chuyển tiếp request đến trang JSP
            request.getRequestDispatcher("/GDTKDocGiaTheoSoLanMuon351.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi xử lý dữ liệu.");
        } catch (ParseException e) {
            request.setAttribute("error", "Định dạng ngày không hợp lệ. Vui lòng nhập ngày theo định dạng yyyy-MM-dd.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private Date convertToDate(String dateStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(dateStr);
        return new Date(utilDate.getTime());
    }
}

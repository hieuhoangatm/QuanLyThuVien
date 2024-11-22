<%@ page import="com.example.apptest.model.PhieuMuon351" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%List<PhieuMuon351> phieuMuonList = (List<PhieuMuon351>) request.getAttribute("phieuMuonList");%>
<h2>Chi tiết các lần mượn của bạn đọc <%= phieuMuonList.get(0).getBanDoc().getHoten() %> theo thống kê từ ${ngayBatDau} đến ${ngayKetThuc}</h2>
<h3>Mã bạn đọc: <%= phieuMuonList.get(0).getBanDoc().getId() %></h3>
<h3>Số điện thoại: <%= phieuMuonList.get(0).getBanDoc().getSodienthoai() %></h3>

<% if (request.getAttribute("phieuMuonList") != null) { %>
<table border="1">
    <tr>
        <th>ID Phiếu mượn</th>
        <th>Ngày Mượn</th>
        <th>Ngày Trả Dự Kiến</th>
        <th>Trạng Thái</th>
        <th>Nhân Viên Thư Viện</th>
        <th>Tổng số lượng tài liệu mượn</th>
    </tr>
    <%
        for (PhieuMuon351 phieuMuon : phieuMuonList) {
    %>
    <tr>
        <td><%= phieuMuon.getId() %></td>
        <td><%= phieuMuon.getNgaymuon() %></td>
        <td><%= phieuMuon.getNgaytradukien() %></td>
        <td><%= phieuMuon.getTrangthai() %></td>
        <td><%= phieuMuon.getThuVien().getHoten() %></td>
        <td><%= phieuMuon.getTongSoluongMuon() %></td>
        <td><a href="chitietphieumuon?id=<%= phieuMuon.getId() %>">Xem chi tiết phiếu mượn</a></td>

    </tr>
    <% } %>
</table>
<% } else { %>
<p>Không có dữ liệu phiếu mượn cho bạn đọc này.</p>
<% } %>

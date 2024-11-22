<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.apptest.model.PhieuMuon351" %>
<%@ page import="com.example.apptest.model.TaiLieuDaMuon351" %>
<%@ page import="java.util.List" %>
<% PhieuMuon351 phieuMuon = (PhieuMuon351) request.getAttribute("phieuMuon"); %>
<h2>Chi tiết phiếu mượn của bạn đọc <%= phieuMuon.getBanDoc().getHoten() %> </h2>
<p>ID Phiếu Mượn: <%= phieuMuon.getId() %></p>
<p>Ngày Mượn: <%= phieuMuon.getNgaymuon() %></p>
<p>Ngày Trả Dự Kiến: <%= phieuMuon.getNgaytradukien() %></p>
<p>Trạng Thái: <%= phieuMuon.getTrangthai() %></p>
<p>Nhân Viên Thư Viện: <%= phieuMuon.getThuVien().getHoten() %></p>
<%--<p>Tổng số lượng tài liệu mượn: <%= phieuMuon.getTongSoluongMuon() %></p>--%>
<p>Tên bạn đọc: <%= phieuMuon.getBanDoc().getHoten() %></p>
<p>Ngày sinh: <%= phieuMuon.getBanDoc().getNgaysinh() %></p>
<p>Email bạn đọc: <%= phieuMuon.getBanDoc().getEmail() %></p>
<p>Số điện thoại: <%= phieuMuon.getBanDoc().getSodienthoai() %></p>
<p>Địa chỉ: <%= phieuMuon.getBanDoc().getDiachi() %></p>
<p>Danh sách tài liệu đã mượn:</p>
<%
    List<TaiLieuDaMuon351> taiLieuList = phieuMuon.getTaiLieuDaMuon351();
%>
<table border="1" style="border-collapse: collapse; width: 100%;">
    <thead>
    <tr>
        <th>ID tài liệu</th>
        <th>Tên tài liệu</th>
        <th>Tác giả</th>
        <th>Năm xuất bản</th>
        <th>Số lượng mượn</th>
    </tr>
    </thead>
    <tbody>
    <% for (TaiLieuDaMuon351 taiLieu : taiLieuList) { %>
    <tr>
        <td><%= taiLieu.getId()%></td>
        <td><%= taiLieu.getTentailieu() %></td>
        <td><%= taiLieu.getTacgia() %></td>
        <td><%= taiLieu.getNamxuatban() %></td>
        <td><%= taiLieu.getSoluongMuon() %></td>
    </tr>
    <% } %>
    </tbody>
</table>




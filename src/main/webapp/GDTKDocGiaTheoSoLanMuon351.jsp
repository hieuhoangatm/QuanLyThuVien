<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.apptest.model.TKBanDocTheoSoLanMuon351" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê độc giả theo số lần mượn</title>
</head>
<body>
<h1>Thống kê bạn đọc theo số lần mượn</h1>

<form action="thong-ke-ban-doc" method="get">
    <label for="ngayBatDau">Ngày bắt đầu:</label>
    <input type="date" id="ngayBatDau" name="ngayBatDau"
           value="${ngayBatDau}" required>
    <br><br>
    <label for="ngayKetThuc">Ngày kết thúc:</label>
    <input type="date" id="ngayKetThuc" name="ngayKetThuc"
           value="${ngayKetThuc}" required>
    <br><br>
    <button type="submit">Thống kê</button>
</form>

<%
    List<TKBanDocTheoSoLanMuon351> listTK = (List<TKBanDocTheoSoLanMuon351>) request.getAttribute("thongKeList");
    if (listTK != null && !listTK.isEmpty()) {
%>
<h2>Kết quả thống kê từ ${ngayBatDau} đến ${ngayKetThuc}</h2>
<table border="1">
    <tr>
        <th>ID Bạn đọc</th>
        <th>Username</th>
        <th>Họ Tên</th>
        <th>Email</th>
        <th>Số Điện Thoại</th>
        <th>Tổng số lần mượn</th>
    </tr>
    <%
        for (TKBanDocTheoSoLanMuon351 tv : listTK) {
    %>
    <tr>
        <td><%= tv.getId() %></td>
        <td><%= tv.getUsername() %></td>
        <td><%= tv.getHoten() %></td>
        <td><%= tv.getEmail() %></td>
        <td><%= tv.getSodienthoai() %></td>
        <td><%= tv.getTongSoLanMuon() %></td>
        <td>
            <a href="caclanmuon?id=<%= tv.getId() %>&ngayBatDau=${ngayBatDau}&ngayKetThuc=${ngayKetThuc}">
                Xem chi tiết các lần mượn
            </a>
        </td>

    </tr>
    <%
        }
    %>
</table>
<%
    }
%>

</body>
</html>

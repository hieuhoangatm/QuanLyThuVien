<%@ page import="com.example.apptest.model.ThanhVien351" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Thành Viên</title>
</head>
<body>
<h1>Danh Sách Thành Viên</h1>
<a href="thanhvien?action=new">Thêm Thành Viên</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Họ Tên</th>
        <th>Email</th>
        <th>Số Điện Thoại</th>
        <th>Hành Động</th>
    </tr>
    <%
        List<ThanhVien351> listThanhVien = (List<ThanhVien351>) request.getAttribute("listThanhVien");
        if (listThanhVien != null) {
            for (ThanhVien351 tv : listThanhVien) {
    %>
    <tr>
        <td><%= tv.getId() %></td>
        <td><%= tv.getUsername() %></td>
        <td><%= tv.getHoten() %></td>
        <td><%= tv.getEmail() %></td>
        <td><%= tv.getSodienthoai() %></td>
        <td>
            <a href="thanhvien?action=edit&id=<%= tv.getId() %>">Sửa</a>
            <a href="thanhvien?action=delete&id=<%= tv.getId() %>">Xóa</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>

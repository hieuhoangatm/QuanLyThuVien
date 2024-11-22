<%@ page import="com.example.apptest.model.TaiLieu351" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tìm Tài Liệu - Thư Viện Trường Học</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<section class="search-section">
    <h2>Tìm Tài Liệu</h2>
    <form action="test" method="get">
        <input type="text" name="query" placeholder="Nhập tên tài liệu..." value="${param.query}">
        <button type="submit">Tìm kiếm</button>
    </form>
</section>

<%
    String query = request.getParameter("query");
    List<TaiLieu351> phieuMuonList = (List<TaiLieu351>) request.getAttribute("resultList");
%>

<% if (query != null && !query.trim().isEmpty()) { %>
<section class="result-section">
    <h3>Kết quả tìm kiếm cho từ khóa "<%= query %>"</h3>
</section>
<% } %>

<% if (phieuMuonList != null && !phieuMuonList.isEmpty()) { %>
<table border="1">
    <tr>
        <th>ID Tài liệu</th>
        <th>Tên tài liệu</th>
        <th>Tên tác giả</th>
        <th>Hành động</th>
    </tr>
    <% for (TaiLieu351 tailieu : phieuMuonList) { %>
    <tr>
        <td><%= tailieu.getId() %></td>
        <td><%= tailieu.getTentailieu() %></td>
        <td><%= tailieu.getTacgia() %></td>
        <td>
            <a href="chitiettailieuu?id=<%= tailieu.getId() %>">Xem chi tiết tài liệu</a>
        </td>
    </tr>
    <% } %>
</table>
<% } else if (query != null && !query.trim().isEmpty()) { %>
<p>Không tìm thấy tài liệu nào cho từ khóa "<%= query %>".</p>
<% } %>

</body>
</html>

<%@ page import="com.example.apptest.model.TaiLieu351" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi Tiết Tài Liệu</title>
</head>
<body>
<% TaiLieu351 taiLieu = (TaiLieu351) request.getAttribute("taiLieu"); %>
<h2>Chi Tiết Tài Liệu có ID : <%= taiLieu.getId() %> </h2>


<% if (taiLieu != null) { %>
<p><strong>ID Tài Liệu:</strong> <%= taiLieu.getId() %></p>
<p><strong>Tên Tài Liệu:</strong> <%= taiLieu.getTentailieu() %></p>
<p><strong>Tác Giả:</strong> <%= taiLieu.getTacgia() %></p>
<p><strong>Năm Xuất Bản:</strong> <%= taiLieu.getNamxuatban() %></p>
<p><strong>Số Lượng Có Sẵn:</strong> <%= taiLieu.getSoluongcosan() %></p>
<p><strong>Thể Loại:</strong> <%= taiLieu.getTheLoai351().getTentheloai() %></p>
<%--<a href="test">Quay lại trang tìm kiếm</a>--%>
<% } else { %>
<p>Không có thông tin chi tiết tài liệu để hiển thị.</p>
<% } %>
</body>
</html>

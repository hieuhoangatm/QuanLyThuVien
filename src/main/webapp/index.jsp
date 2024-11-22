<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trang Chủ - Quản Lý Thư Viện</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
    }
    header {
      background-color: #0078D7;
      color: white;
      padding: 15px 20px;
      text-align: center;
    }
    nav {
      background-color: #333;
      overflow: hidden;
    }
    nav a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 14px 20px;
      text-decoration: none;
    }
    nav a:hover {
      background-color: #575757;
    }
    .container {
      padding: 20px;
    }
    footer {
      text-align: center;
      padding: 10px;
      background-color: #333;
      color: white;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>
<!-- Header -->
<header>
  <h1>Hệ Thống Quản Lý Thư Viện</h1>
</header>

<!-- Navigation Bar -->
<nav>
  <a href="index.jsp">Trang chủ</a>
  <a href="thanhvien-list.jsp">Quản lý chung</a>
  <a href="GDChonTK351.jsp">Thống kê</a>
  <a href="logout.jsp">Đăng Xuất</a>
</nav>

<!-- Content -->
<div class="container">
  <h2>Chào mừng bạn đến với hệ thống quản lý thư viện</h2>
  <p>Hệ thống giúp quản lý tài liệu, bạn đọc, mượn trả, và báo cáo thống kê một cách dễ dàng.</p>
  <p>Hãy chọn một chức năng từ menu phía trên để bắt đầu.</p>
</div>

<!-- Footer -->
<footer>
  <p>© 2024 Hệ Thống Quản Lý Thư Viện. All Rights Reserved.</p>
</footer>
</body>
</html>

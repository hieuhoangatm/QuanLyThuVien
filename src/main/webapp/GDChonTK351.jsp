<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thống Kê - Quản Lý Thư Viện</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f9f9f9;
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
      max-width: 600px;
      margin: 0 auto;
      background-color: white;
      box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
      border-radius: 5px;
    }
    h2 {
      text-align: center;
      color: #333;
    }
    .statistic-options {
      list-style-type: none;
      padding: 0;
    }
    .statistic-options li {
      margin: 10px 0;
    }
    .statistic-options a {
      display: block;
      text-decoration: none;
      background-color: #0078D7;
      color: white;
      padding: 10px 15px;
      border-radius: 5px;
      text-align: center;
    }
    .statistic-options a:hover {
      background-color: #005bb5;
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
  <h1>Thống Kê - Hệ Thống Quản Lý Thư Viện</h1>
</header>

<!-- Navigation -->
<nav>
  <a href="index.jsp">Trang Chủ</a>
  <a href="thanhvien-list.jsp">Quản Lý Chung</a>
  <a href="GDChonTK351.jsp">Thống Kê</a>
  <a href="logout.jsp">Đăng Xuất</a>
</nav>

<!-- Content -->
<div class="container">
  <h2>Chọn Loại Thống Kê</h2>
  <ul class="statistic-options">
    <li><a href="GDTKDocGiaTheoSoLanMuon351.jsp">Thống Kê Độc Giả Theo Lượt Mượn</a></li>
    <li><a href="documentStatistics.jsp">Thống Kê Tài Liệu Theo Số Lần Mượn</a></li>
    <li><a href="returnStatistics.jsp">Thống Kê Nhà Cung Cấp Theo Số Lượng Tài liệu Nhập</a></li>

  </ul>
</div>

<!-- Footer -->
<footer>
  <p>© 2024 Hệ Thống Quản Lý Thư Viện. All Rights Reserved.</p>
</footer>
</body>
</html>

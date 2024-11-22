<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Thư Viện Trường Học</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
    <div class="logo">
        <h1>Thư Viện Trường Học</h1>
    </div>
    <nav>
        <ul>
            <li><a href="GDChinhBanDoc351.jsp">Trang Chủ</a></li>
            <li><a href="gdTimTaiLieu351.jsp">Tìm tài liệu</a></li>
            <li><a href="info.jsp">Giới thiệu</a></li>
            <li><a href="tintuc.jsp">Tin tức</a></li>
            <li><a href="lienhe.jsp">Liên hệ</a></li>
            <li><a href="profile.jsp">Tài khoản của tôi</a></li>
            <li><a href="logout.jsp">Đăng Xuất</a></li>
        </ul>
    </nav>
</header>

<%--<section class="search-section">--%>
<%--    <h2>Tìm Sách</h2>--%>
<%--    <form action="search.jsp" method="get">--%>
<%--        <input type="text" name="query" placeholder="Nhập tên sách hoặc tác giả...">--%>
<%--        <button type="submit">Tìm kiếm</button>--%>
<%--    </form>--%>
<%--</section>--%>

<section class="notifications">
    <h2>Thông Báo</h2>
    <ul>
        <li>Hệ thống thư viện hiện đã có sách mới, hãy kiểm tra ngay!</li>
        <li>Hạn cuối trả sách cho kỳ này: 20/12/2024.</li>
    </ul>
</section>

<footer>
    <p>&copy; 2024 Thư Viện Trường Học. Tất cả các quyền được bảo lưu.</p>
</footer>
</body>
</html>

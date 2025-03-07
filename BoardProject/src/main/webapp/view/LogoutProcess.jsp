<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <%
        // 세션 종료후 메인 페이지로
        session.invalidate();
    %>
<script>
    alert("로그 아웃 되었습니다");
    location.href = "main.jsp";
</script>
</body>
</html>
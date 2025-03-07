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
        Cookie c = new Cookie("id", "hong");
        c.setMaxAge(600);
        response.addCookie(c);
        Cookie c2 = new Cookie("age", "12");
        response.addCookie(c2);
    %>
    <h2>쿠키생성</h2>
</body>
</html>
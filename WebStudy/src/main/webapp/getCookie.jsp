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
    <h2>클라이언트에서 받아온 Cookie</h2>
    <%
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies) {
            out.println(c.getName() + " : " + c.getValue() + "<br>");
        }
    %>
</body>
</html>
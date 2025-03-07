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
        session.setAttribute("id", "hong");
        session.setAttribute("pwd", "test1234");
        session.setAttribute("age", 20);

    %>
    <h3>세션 설정</h3>
</body>
</html>
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
        // 세션이 생성된 시간
        long createTime = session.getCreationTime();
        // 세션의 최종 접속 시간
        long lastTime = session.getLastAccessedTime();

        long diff = (lastTime - createTime) / 6000;
    %>

    차이난 시간 = <%= diff %> <br>
</body>
</html>
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
    이 파일은 red.jsp입니다.
    <jsp:forward page = "yellow.jsp">
        <jsp:param name = "id" value = "powerranger" />
        <jsp:param name = "job" value = "kamenrider" />
    </jsp:forward>
</body>
</html>
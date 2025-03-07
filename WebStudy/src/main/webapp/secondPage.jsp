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
    page영역 : <%= pageContext.getAttribute("name") %> <br>
    request영역 : <%= request.getAttribute("name") %> <br>
    session영역 : <%= session.getAttribute("name") %> <br>
    application영역 : <%= application.getAttribute("name") %> <br>
    <a href="thirdPage.jsp">세번째 페이지</a>
</body>
</html>
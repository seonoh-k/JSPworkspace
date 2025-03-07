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
        // Attribute : 반환타입이 Object
        String id = (String)session.getAttribute("id");
        String pwd = (String)session.getAttribute("pwd");
        Integer age = (Integer)session.getAttribute("age");

    %>

    id : <%= id %> <br>
    pwd : <%= pwd %> <br>
    age : <%= age %>
</body>
</html>
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
    <form method = "post" action = "WriteBoardProcess.jsp">
        <input type = "text" name = "title" id = "title">
        <input type = "submit" value = "등록"><br>
        <textarea name = "content" id = "content" placeholder="내용을 입력하세요" rows="4" cols="50"></textarea>
    </form>
</body>
</html>
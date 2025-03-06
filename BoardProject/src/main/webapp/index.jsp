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
    <form method = "post" action ="MainServlet">
        아이디 : <input type = "text" name = "id" id = "id"> <br>
        비밀번호 : <input type = "password" name = "pwd" id = "pwd"> <br>
        <input type = "submit" name = "whereto" value = "로그인">
        <input type = "submit" name = "whereto" value = "회원가입">
    </form>
</body>
</html>

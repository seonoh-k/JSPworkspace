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
    <form method = "get" action = "LoginProcess.jsp">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type = "text" name = "id" id = "id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type = "password" name = "pwd" id = "pwd"></td>
            </tr>
        </table>
        <br>
        <input type = "submit" value = "로그인">
    </form>
</body>
</html>
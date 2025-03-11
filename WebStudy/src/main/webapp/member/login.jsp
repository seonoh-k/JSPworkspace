<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="script/member.js"></script>
</head>
<body>
    <h2>로그인</h2>
       <form action="login.do" method="post" name="frm">
          <table>
             <tr>
                <td>아이디</td>
                <td><input type="text" name="userid" ></td>
             </tr>
             <tr>
                <td>암 호</td>
                <td><input type="password" name="pwd"></td>
             </tr>
             <tr>
                <td colspan="2" align="center">
                    ${message}
                </td>
             </tr>
             <tr>
                <td colspan="2"></td>
                <input type = "submit" value = "로그인" onclick = "return loginCheck()">
                <input type = "reset" value = "취소">
                <input type = "button" value = "회원가입" onclick = "location.href='member/join.jsp'">
             </tr>
          </table>
       </form>
</body>
</html>
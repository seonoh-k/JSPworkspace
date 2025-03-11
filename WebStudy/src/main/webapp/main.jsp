<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h2>회원 전용 페이지</h2>
       <form action="logout.do">
          <table>
             <tr>
                <td>안녕하세요. ${loginUser.name}(${loginUser.userid})</td>
             </tr>
             <tr>
                <td colspan="2" align="center">
                <input type = "submit" value = "로그아웃">
                <input type = "button" value = "회원정보변경" onclick = "location.href = memberUpdate.do?userid = '${loginUser.userid}'">
                </td>
             </tr>
          </table>
       </form>
</body>
</html>
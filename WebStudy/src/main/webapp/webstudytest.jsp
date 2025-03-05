<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
 <!-- action = form 태그 내의 결과를 반환할 위치 -->
 <!-- 기본 주소 = '기본 url/' http://localhost:9999/WebStudy/ -->
 <!-- action = "기본 주소 + 자바 클래스 이름" -->
 <!-- method = 서블릿 요청 방식 -->
    <form action = "MethodServlet" method = "get"> <!-- 서블릿 요청 -->
    <input type = "submit" value = "get 방식으로 호출하기">
    </form>

    <form action = "MethodServlet" method = "post">
    <input type = "submit" value = "post 방식으로 호출하기">
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%!
    // 선언문
    // 변수 선언
    // 메소드 정의
     String str = "느금마 고려장";
     public int add(int a, int b) {
        return a + b;
     }
%>
<%
    // 스크립트릿
    // 변수 선언 (전역 변수)
    // 메소드 정의
    // 변수의 값 출력
    // 메소드 호출
%>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>

    <%
        // 스크립트릿
        // 변수선언 (전역변수)
        // 메소드 정의
        // 변수의 값 출력
        // 메소드 호출
        out.print(str + "<br>");
        out.print("<span style = 'color : red'>" + add(3, 5) + "</span>");
    %>

    <h2>표현식</h2>
    변수를 출력한다 <br>
    <%= str %> <br>
    리턴값이 있는 메소드를 출력한다 <br>
    <span style = 'color : red'><%= add(3, 5) %></span>
</body>
</html>
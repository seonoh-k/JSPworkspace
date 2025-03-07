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
        String appContextPath = application.getContextPath();
        String filePath = application.getRealPath("application.jsp");
        String mimeType = application.getMimeType("application.jsp");
    %>

    컨텍스트 패스명 :
    <%= appContextPath %> <br>
    애플리케이션 파일 경로명 :
    <%= filePath %> <br>
    애플리케이션 파일 mimeType :
    <%= mimeType %>

</body>
</html>

<%-- 영역 객체 : 사용가능한 범위 (페이지 단위)
page < request < session < application --%>

http://localhost:9990/WebStudy/thirdPage.jsp
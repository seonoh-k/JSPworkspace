<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <%
        // response.sendRedirect("상대경로 / 절대경로");
        response.sendRedirect("researchForm.jsp");
        // response.sendRedirect("WebStudy/researchForm.jsp"); - 경로를 찾을 수 없음.
        // http://localhost:9990/WebStudy : Redirect 방식 기준 경로
        //                             /researchForm.jsp : 상대경로
        //                    /WebStudy/researchForm.jsp : 절대경로
        // 특징 : 페이지 이동 후 URL 정보가 현재 페이지로 변경된다.
    %>
</body>
</html>
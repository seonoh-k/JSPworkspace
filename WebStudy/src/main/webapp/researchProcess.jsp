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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String[] items = request.getParameterValues("item");

        out.println(name + "<br>");
        out.println(gender + "<br>");
        for(String i : items) {
            out.println(i + "<br>");
        }
    %>
</body>
</html>
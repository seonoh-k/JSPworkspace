<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>

    컨텍스트 : <%= request.getContextPath() %> <br>
    URL : <%= request.getRequestURL() %> <br>
    URI : <%= request.getRequestURI() %> <br>
    Query String : <%= request.getQueryString() %> <br>
    session : <%= request.getSession() %> <br>
</body>
</html>
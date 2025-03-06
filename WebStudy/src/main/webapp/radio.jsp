<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form method = "get" action = "RadioServlet">
        성별 : <input type = "radio" name = "gender" value = "남자"> 남자
               <input type = "radio" name = "gender" value = "여자"> 여자
        <br>
        인사말 :
        <textarea name = "content" rows = "3" cols = "35"></textarea>
        <br>
        <input type = "submit" value = "전송">
    </form>
</body>
</html>
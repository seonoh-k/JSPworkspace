<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h2>관심항목 선택</h2><br>
    <form method = "get" action = "CheckboxServlet">
        성별 : <input type = "checkbox" name = "item" value = "신발"> 신발
              <input type = "checkbox" name = "item" value = "모자"> 모자
              <input type = "checkbox" name = "item" value = "시계"> 시계
        <br>
        <input type = "submit" value = "전송">
    </form>
</body>
</html>
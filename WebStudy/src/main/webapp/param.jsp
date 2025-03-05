<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<!-- 쿼리 스트링 -> ?id=seonohkim&age=32 -->
<!-- ? (name 속성값) = (value 속성값) -->
     <form action = "ParamServlet" method = "get">
        아이디 : <input type = "text" name = "id"><br>
        나   이 : <input type = "text" name = "age"><br>
        <input type = "submit" value = "전송">
     </form>

<!-- http://localhost:9999/WebStudy/ParamServlet -->
<!-- post 방식은 입력 데이터가 url에 노출되지 않는다 -->
     <form action = "ParamServlet" method = "post">
         아이디 : <input type = "text" name = "id"><br>
         나   이 : <input type = "text" name = "age"><br>
         <input type = "submit" value = "전송">
     </form>
</body>
</html>
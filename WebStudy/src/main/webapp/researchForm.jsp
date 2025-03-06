<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h2>설문조사</h2>
    <form method = "post" action = "researchProcess.jsp">
        이름 : <input type = "text" name = "name" id = "name"> <br>
        성별 : <input type = "radio" name = "gender" value = "남자"> 남자
              <input type = "radio" name = "gender" value = "여자"> 여자 <br>

        관심 제품
        <input type = "checkbox" name = "item" value = "신발"> 신발
        <input type = "checkbox" name = "item" value = "모자"> 모자
        <input type = "checkbox" name = "item" value = "시계"> 시계
        <br>
        <input type = "submit" value = "전송">
        <input type = "reset" value = "취소">

    </form>
</body>
</html>
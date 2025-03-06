<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form method = "get" action = "RegistServlet">
        아이디 : <input type = "text" name = "id" id = "id"> <br>
        비밀번호 : <input type = "password" name = "pwd" id = "pwd"> <br>
        이름 : <input type = "text" name = "name" id = "name"> <br>
        이메일 : <input type = "text" name = "email" id = "email"> <br>
        성별 : <input type = "radio" name = "gender" value = "남"> 남자
              <input type = "radio" name = "gender" value = "여"> 여자 <br>
        생년월일 : <input type = "text" name = "birth" id = "birth"> <br>
        <input type="submit" value="전송">
    </form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form method = "get" action = "SelectServlet">
        <select name = "job" size = "">
            <option value = "">==직업을 선택하세요==</option>
            <option value = "학생">학생</option>
            <option value = "군인">군인</option>
            <option value = "회사원">회사원</option>
        </select>
        <br>
        <select name = "jobs" size = "4" multiple = "multiple">
            <option value = "">==직업을 선택하세요==</option>
            <option value = "학생">학생</option>
            <option value = "군인">군인</option>
            <option value = "회사원">회사원</option>
        </select>
        <br>
        <input type = "submit" value = "전송">
    </form>
</body>
</html>
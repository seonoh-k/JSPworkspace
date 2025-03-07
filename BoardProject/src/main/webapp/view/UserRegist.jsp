<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form method = "get" action = "UserRegistProcess.jsp">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type = "text" name = "id" id = "id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type = "password" name = "pwd" id = "pwd"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input type = "text" name = "user_email" id = "user_email">@
                    <select name = "domain" size = "">
                        <option value = "" disabled selected>선택</option>
                        <option value = "naver.com">naver.com</option>
                        <option value = "gmail.com">gmail.com</option>
                        <option value = "kakao.com">kakao.com</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type = "text" name = "name" id = "name"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type = "radio" name = "gender" value = "남"> 남자
                    <input type = "radio" name = "gender" value = "여"> 여자
                </td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td>
                <select name = "year" id = "year">
                    <option value = "">연도</option>
                </select>년
                <select name = "month" id = "month">
                    <option value = "">월</option>
                </select>월
                <select name = "day" id = "day">
                    <option value = "">일</option>
                </select>일
                </td>
            </tr>
        </table>
        <br>
        <input type = "submit" value = "회원가입">
    </form>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var currentYear = new Date().getFullYear();
            var pastYear = currentYear - 100;
            var yearSelect = document.getElementById("year");

            for (var i = currentYear; i >= pastYear; i--) {
                var option = document.createElement("option");
                option.value = i;
                option.text = i;
                yearSelect.appendChild(option);
            }

            var monthSelect = document.getElementById("month");

            for (var month = 1; month <= 12; month++) {
                var option = document.createElement("option");
                option.value = month;
                option.text = month;
                monthSelect.appendChild(option);
            }

            var daySelect = document.getElementById("day");

            for (var day = 1; day <= 31; day++) {
                var option = document.createElement("option");
                option.value = day;
                option.text = day;
                daySelect.appendChild(option);
            }
        })
    </script>
</body>
</html>
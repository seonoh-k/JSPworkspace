<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        #wrap {
        	width: 971px; /* 1024*768로 해상도를 맞추어서 설계 */
        	/* 가운데 정렬을 위한 바깥쪽 여백 설정 */
        	margin: 0;
        	margin-left: auto;
        	margin-right: auto;
        }

        h1 {
        	color: green; /* 글 색상 */
        }

        table {
        	width: 100%;
        	border-collapse: collapse;
        	font-size: 12px; /* 글꼴 크기 */
        	line-height: 24px; /* 줄 간격 */
        }

        table td,th {
        	border: #d3d3d3 solid 1px; /* 경계선 색상 스타일 굵기 */
        	padding: 5px; /* 안쪽 여백 */
        }

        th {
        	background: yellowgreen; /* 배경색 */
        }

        img {
        	width: 220px; /* 이미지 너비(가로) */
        	height: 300px; /* 이미지 높이(세로) */
        }

        a {
        	text-decoration: none; /* 링크 밑줄 없애기 */
        	color: black; /* 글 색상 */
        }

        a:HOVER {
        	text-decoration: underline; /* 밑줄 */
        	color: green; /* 글 색상 */
        }
    </style>
</head>
<body>
    <form name="frm" method = "post" action = "BoardServlet">
        <input type="hidden" name="command" value="board_check_pass">
        <table align="center">
            <tr>
                <th>비밀번호 입력</th>
            </tr>
            <tr>
                <td align="center">
                    <input type="password" name="pass">
                    <input type="submit" value="확인" onclick="return boardCheck()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
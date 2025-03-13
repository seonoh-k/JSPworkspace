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
    <link rel="stylesheet" type="text/css" href="css/shopping.css">
    <script type="text/javascript" src="script/board.js"></script>
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
<div id="wrap" align="center">
   <h1>게시글 등록</h1>
   <form name="frm" method="post" action="BoardServlet">
      <input type="hidden" name="command" value="board_write">
      <table>
         <tr>
            <th>작성자</th>
            <td><input type="text" name="name"> * 필수</td>
         </tr>
         <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pass"> * 필수 (게시물 수정
               삭제시 필요합니다.)</td>
         </tr>
         <tr>
            <th>이메일</th>
            <td><input type="text" name="email"></td>
         </tr>
         <tr>
            <th>제목</th>
            <td><input type="text" size="70" name="title"> * 필수</td>
         </tr>
         <tr>
            <th>내용</th>
            <td><textarea cols="70" rows="15" name="content"></textarea></td>
         </tr>
      </table>
      <br>
      <br>
      <input type="submit" value="등록" onclick="return boardCheck()">
      <input type="reset" value="다시 작성">
      <input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
   </form>
</div>
</body>
</html>
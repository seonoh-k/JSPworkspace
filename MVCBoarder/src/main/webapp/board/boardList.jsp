<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    int nowpage = ((Integer)request.getAttribute("page")).intValue();
    int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
    int startpage = ((Integer)request.getAttribute("startpage")).intValue();
    int endpage = ((Integer)request.getAttribute("endpage")).intValue();
    int listcount = ((Integer)request.getAttribute("listcount")).intValue();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/shopping.css">
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
    <title>hi</title>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 리스트</h1>
    <table>
        <tr>
            <td colspan="5" style="border : white; text-align : right">
                <a href="BoardServlet?command=board_write_form">게시글 등록</a>
            </td>
        </tr>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
        </tr>
        <c:forEach var = "board" items = "${boardList}">
            <tr>
                <td>${board.num}</td>
                <td><a href="BoardServlet?command=board_view&num=${board.num}">${board.title}</a></td>
                <td>${board.name}</td>
                <td><fmt:formatDate value="${board.writedate}"/></td>
                <td>${board.readcount}</td>
            </tr>
        </c:forEach>
        <tr align="center" height=20>
            <td colspan="5" style="font-family:Tahoma;font-size:10pt">
                <%
                    if(nowpage <= 1) {%>
                        [이 전]&nbsp;&nbsp;
                    <%}else {%>
                        <a href="./BoardServlet?command=board_list&page=<%=nowpage-1%>">[이 전]</a>
                    <%}
                %>
                <%
                    for(int num=startpage;num<=endpage;num++) {
                        if(num == nowpage) {%>
                            [<%= num %>]
                        <%}else {%>
                            <a href="./BoardServlet?command=board_list&page=<%=num%>">&nbsp;[<%= num %>]&nbsp;</a>
                        <%}
                    }
                %>
                <%
                    if(nowpage >= maxpage) {%>
                        &nbsp;&nbsp;[다 음]
                    <%}else {%>
                        <a href="./BoardServlet?command=board_list&page=<%=nowpage+1%>">[다 음]</a>
                    <%}
                %>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
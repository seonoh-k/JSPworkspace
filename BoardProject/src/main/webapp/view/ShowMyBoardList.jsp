<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Board.DTO.BoardDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내가 쓴 글 목록</title>
    <style>
        table {
            width : 1000px;
        }
        table th {
            height : 20px;
        }
        table td {
            height : 30px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일자</th>
        </tr>
        <%
            ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)request.getAttribute("boardList");
            if(boardList != null && !boardList.isEmpty()) {
                for(BoardDTO board : boardList) {
                    String date = (board.getUpdate_at() == null) ? sdf.format(board.getCreate_at()) : sdf.format(board.getUpdate_at());
        %>
        <tr onclick="location.href='ShowBoardDetailProcess.jsp?board_no=<%= board.getBoard_no() %>'">
            <td><%= board.getBoard_no() %></td>
            <td><%= board.getTitle() %></td>
            <td><%= board.getUser_id() %></td>
            <td><%= date %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>

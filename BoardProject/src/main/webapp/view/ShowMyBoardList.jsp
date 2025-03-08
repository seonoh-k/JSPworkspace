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
    <title></title>
</head>
<body>
    <table>
        <tr>
            <td>글 번호</td>
            <td colspan=3>제목</td>
            <td>작성자</td>
            <td>작성일자</td>
        </tr>
        <%
            ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)request.getAttribute("boardList");
            if(boardList != null && !boardList.isEmpty()) {
                for(BoardDTO board : boardList) {
                    String date = (board.getUpdate_at() == null) ? sdf.format(board.getCreate_at()) : sdf.format(board.getUpdate_at());
        %>
        <tr>
            <td><%= board.getBoard_no() %></td>
            <td colspan=3><%= board.getTitle() %></td>
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

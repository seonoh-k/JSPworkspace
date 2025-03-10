<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="Board.DTO.BoardDTO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <%
        BoardDTO modifyBoard = (BoardDTO)request.getAttribute("modifyBoard");
        if(modifyBoard != null) {
    %>
            <form method="post" action="UpdateBoardProcess.jsp">
                <input type = "hidden" name = "board_no" id = "board_id" value = "<%= modifyBoard.getBoard_no() %>">
                <input type = "text" name = "title" id = "title" value="<%= modifyBoard.getTitle() %>">
                <input type = "submit" value = "수정"><br>
                <textarea name = "content" id = "content" rows="4" cols="50"><%= modifyBoard.getContent() %></textarea>
            </form>
    <%
        }
    %>
</body>
</html>
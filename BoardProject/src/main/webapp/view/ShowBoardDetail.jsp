<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Board.DTO.BoardDetailDTO" %>
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
        <%
            ArrayList<BoardDetailDTO> boardDetailList = (ArrayList<BoardDetailDTO>)request.getAttribute("boardDetailList");
            BoardDetailDTO board = boardDetailList.get(0);
            String date = (board.getB_update_at() == null) ? sdf.format(board.getB_create_at()) : sdf.format(board.getB_update_at());
        %>
        <tr>
            <th colspan=2><%= board.getTitle() %></th>
            <th><%= board.getB_user_id() %></th>
            <th><%= date %></th>
        </tr>
        <tr>
            <td colspan=4><%= board.getB_content() %></td>
        </tr>
        <%
            for (int i=0; i<boardDetailList.size(); i++) {
                BoardDetailDTO comment = boardDetailList.get(i);
                String commentDate = (comment.getC_update_at() == null) ? sdf.format(comment.getC_create_at()) : sdf.format(comment.getC_update_at());
        %>
        <tr>
            <% if(comment.getRef() == 0) { %>
            <td><%= comment.getC_user_id() %></td>
            <td><%= comment.getC_content() %></td>
            <td><%= commentDate %></td>
            <%}else {%>
            <td>↳</td>
            <td><%= comment.getC_user_id() %></td>
            <td><%= comment.getC_content() %></td>
            <td><%= commentDate %></td>
            <% } %>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
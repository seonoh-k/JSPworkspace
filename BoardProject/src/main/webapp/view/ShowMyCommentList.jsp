<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Comment.DTO.CommentDTO" %>
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
            <td colspan=3>댓글 내용</td>
            <td>작성자</td>
            <td>작성일자</td>
        </tr>
        <%
            ArrayList<CommentDTO> commentList = (ArrayList<CommentDTO>)request.getAttribute("commentList");
            if(commentList != null && !commentList.isEmpty()) {
                for(CommentDTO comment : commentList) {
                    String date = (comment.getUpdate_at() == null) ? sdf.format(comment.getCreate_at()) : sdf.format(comment.getUpdate_at());
        %>
                    <tr onclick="location.href='ShowBoardDetailProcess.jsp?board_no=<%= comment.getBoard_no() %>'">
                        <td><%= comment.getBoard_no() %></td>
                        <td colspan=3><%= comment.getContent() %></td>
                        <td><%= comment.getUser_id() %></td>
                        <td><%= date %></td>
                    </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
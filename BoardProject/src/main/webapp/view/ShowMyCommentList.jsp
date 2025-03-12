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
    <title>내가 쓴 댓글 목록</title>
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
            <th>댓글 내용</th>
            <th>작성자</th>
            <th>작성일자</th>
        </tr>
        <%
            ArrayList<CommentDTO> commentList = (ArrayList<CommentDTO>)request.getAttribute("commentList");
            if(commentList != null && !commentList.isEmpty()) {
                for(CommentDTO comment : commentList) {
                    String date = (comment.getUpdate_at() == null) ? sdf.format(comment.getCreate_at()) : sdf.format(comment.getUpdate_at());
        %>
                    <tr onclick="location.href='ShowBoardDetailProcess.jsp?board_no=<%= comment.getBoard_no() %>'">
                        <td><%= comment.getBoard_no() %></td>
                        <td><%= comment.getContent() %></td>
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
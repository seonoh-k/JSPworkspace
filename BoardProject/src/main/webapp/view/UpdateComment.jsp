<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>


<%
    CommentDTO modifyComment = (CommentDTO)request.getAttribute("modifyBoard");
    if(modifyComment != null) {
%>
<form method = "post" action = "UpdateCommentProcess.jsp">
    <input type ="hidden" name = "board_no" value = "<%= modifyComment.getBoard_no() %>">
    <input type ="hidden" name = "comment_no" value = "<%= modifyComment.getComment_no() %>">
    <textarea name = "content" id = "content" required><%= modifyComment.getContent() %></textarea>
    <input type = "submit" value = "댓글 수정">
</form>
<%
    }
%>


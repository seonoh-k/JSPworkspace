<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="Comment.DTO.CommentDTO"%>

<%
    CommentDTO modifyComment = (CommentDTO)request.getAttribute("modifyComment");
    if(modifyComment != null) {
%>
<td onclick="eventHandler(event)">
<form method = "post" action = "UpdateCommentProcess.jsp">
    <input type ="hidden" name = "board_no" value = "<%=modifyComment.getBoard_no()%>">
    <input type ="hidden" name = "comment_no" value = "<%=modifyComment.getComment_no()%>">
    <textarea name = "content" id = "content" required><%=modifyComment.getContent()%></textarea>
    <input type = "submit" value = "댓글 수정">
    <input type = "button" value = "취소" onclick = "location.href='ShowBoardDetailProcess.jsp?board_no=<%= modifyComment.getBoard_no() %>'">
</form>
</td>
<%}%>

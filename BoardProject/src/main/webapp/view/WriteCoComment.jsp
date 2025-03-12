<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<form method = "get" action = "WriteCoCommentProcess.jsp">
    <input type ="hidden" name = "user_no" value = "<%= session.getAttribute("user_no") %>">
    <input type ="hidden" name = "board_no" value = "<%= request.getParameter("board_no") %>">
    <input type ="hidden" name = "comment_no" value = "<%= request.getParameter("comment_no") %>">
    <textarea cols="30" rows="1" name = "content" id = "content" required></textarea>
    <input type = "submit" value = "댓글 등록">
</form>


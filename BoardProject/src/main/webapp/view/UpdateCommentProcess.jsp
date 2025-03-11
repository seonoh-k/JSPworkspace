<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    String content = request.getParameter("content");
    String comment_no = request.getParameter("comment_no");
    String board_no = request.getParameter("board_no");

    if(content != null) {
            request.setAttribute("content", content);
    }
    if(comment_no != null) {
            request.setAttribute("comment_no", comment_no);
    }
    if(board_no != null) {
            request.setAttribute("comment_no", board_no);
    }
%>

<jsp:forward page="/UpdateCommentController"/>
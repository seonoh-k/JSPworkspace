<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    String user_no = request.getParameter("user_no");
    String board_no = request.getParameter("board_no");
    String content = request.getParameter("content");
    String comment_no = request.getParameter("comment_no");

%>

<jsp:forward page="/WriteCommentController"/>
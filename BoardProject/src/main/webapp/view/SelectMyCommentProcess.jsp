<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    String comment_no = request.getParameter("comment_no");
    if(comment_no != null) {
        request.setAttribute("comment_no", comment_no);
    }
%>

<jsp:forward page="/UpdateCommentController"/>
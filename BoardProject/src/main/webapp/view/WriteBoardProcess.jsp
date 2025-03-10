<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    String title = request.getParameter("title");
    String content = request.getParameter("content");

%>

<jsp:forward page="/WriteBoardController"/>
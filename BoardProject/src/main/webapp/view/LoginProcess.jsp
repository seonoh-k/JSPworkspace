<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%

    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

%>

<jsp:forward page="/UserLoginController"/>
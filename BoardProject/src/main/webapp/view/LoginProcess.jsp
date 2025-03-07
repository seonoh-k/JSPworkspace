<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    // 로그인 성공 실패 유무에 따라 다른 기능.
    // 성공 - 메인페이지
    // 실패 다시 로그인페이지
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    request.getRequestDispatcher("/UserLoginController").forward(request, response);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.net.URLEncoder"%>

<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String id = request.getParameter("id");
    String userpwd = request.getParameter("userpwd");

    // forward 방식의 페이지 이동
    // request와 response의 제어권을 같이 넘겨준다
    RequestDispatcher dis = request.getRequestDispatcher("LoginSuccess3.jsp"); dis.forward(request, response);

%>
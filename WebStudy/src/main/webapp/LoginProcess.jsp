<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.net.URLEncoder"%>

<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String id = request.getParameter("id");
    String userpwd = request.getParameter("userpwd");

    // sendRedirect 사용시 request에 저장된 값이 사라진다.
    // response.sendRedirect("LoginSuccess.jsp");

    // get 방식으로 데이터를 request에 저장해 넘긴다.
    // response.sendRedirect("LoginSuccess.jsp?id=" + id);

    // 한글 데이터 강제 인코딩 처리
    response.sendRedirect("LoginSuccess.jsp?id=" + URLEncoder.encode(id, "UTF-8"));

%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%

    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String usr_email = request.getParameter("user_email");
    String domain = request.getParameter("domain");
    String gender = request.getParameter("gender");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");


    RequestDispatcher dis = request.getRequestDispatcher("/UserRegistController");
    dis.forward(request, response);

%>
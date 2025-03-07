<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    pageContext.setAttribute("name", "page man");
    request.setAttribute("name", "request man");
    session.setAttribute("name", "session man");
    application.setAttribute("name", "application man");

    out.println("page영역 : " + pageContext.getAttribute("name"));
    out.println("request영역 : " + request.getAttribute("name"));
    out.println("session영역 : " + session.getAttribute("name"));
    out.println("application영역 : " + application.getAttribute("name"));
    request.getRequestDispatcher("secondPage.jsp").forward(request, response);
%>
page영역 : <%= pageContext.getAttribute("name") %> <br>
request영역 : <%= request.getAttribute("name") %> <br>
session영역 : <%= session.getAttribute("name") %> <br>
application영역 : <%= application.getAttribute("name") %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%

    String inactiveToday = request.getParameter("inactiveToday");
    if(inactiveToday != null && inactiveToday.equals("1")) {
        Cookie c = new Cookie("PopupClose", "off");
        c.setMaxAge(60 * 60 * 24);
        response.addCookie(c);
    }

%>
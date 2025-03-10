<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    String board_no = request.getParameter("board_no");
    if(board_no != null) {
        request.setAttribute("board_no", board_no);
    }
%>

<jsp:forward page="/UpdateBoardController"/>
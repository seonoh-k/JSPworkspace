<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    // 삭제 버튼 누를시 호출. 페이지 표시 없이 데이터 삭제 처리만 하고 바로 전 페이지로 돌아간다.
    String board_no = request.getParameter("board_no");

    <jsp:forward page="/DeleteBoardController"/>
%>
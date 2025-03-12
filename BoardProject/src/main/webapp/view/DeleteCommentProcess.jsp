<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    // 삭제 버튼 누를시 호출. 페이지 표시 없이 데이터 삭제 처리만 한다.
    String comment_no = request.getParameter("comment_no");
%>
<jsp:forward page="/DeleteCommentController" />
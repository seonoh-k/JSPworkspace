<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp" %>

<div id="login">
    <form method="post" action="NonageServlet?command=admin_login">
        <fieldset>
        <legend>Admin Login</legend>
            <label>Admin ID</label>
            <input name="id" type="text" value="${id}"><br>
            <label>Password</label>
            <input name="pwd" type="password" value=""><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="업무 로그인" class="submit">
        </div>
    </form>
</div>

<%@ include file="../footer.jsp" %>
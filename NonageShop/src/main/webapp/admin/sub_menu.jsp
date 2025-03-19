<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav id="sub_menu">
    <h2>Admin Setting</h2>
    <ul>
        <li><a href="NonageServlet?command=admin_product_list">상품리스트</a></li>
        <li><a href="NonageServlet?command=admin_order_list">주문리스트</a></li>
        <li><a href="#">회원리스트</a></li>
        <li><a href="NonageServlet?command=admin_qna_list">Q&A리스트</a></li>
    </ul>
</nav>
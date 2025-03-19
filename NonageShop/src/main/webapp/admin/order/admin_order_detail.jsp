<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<article>
    <div>
        <h2>주문 상세 보기</h2>
        <table id="detail">
            <tr>
                <th>주문 번호</th>
                <td>${order.oseq}</td>
                <th>회원 아이디</th>
                <td>${order.id}</td>
            </tr>
            <tr>
                <th>상품 번호</th>
                <td>${order.pseq}</td>
                <th>상품명</th>
                <td>${order.pname}</td>
                <th>주문일</th>
                <td><fmt:formatDate value="${order.indate}" type="date"/></td>
            </tr>
            <tr>
                <th>판매가</th>
                <td>${order.price2}</td>
                <th>주문 수량</th>
                <td>${order.quantity}</td>
                <th>주문 금액</th>
                <td>${order.price2*order.quantity}</td>
            </tr>
            <tr>
                <th>주문자명</th>
                <td>${order.mname}</td>
                <th>우편번호</th>
                <td>${order.zipNum}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td colspan="5">${order.address}</td>
            </tr>
            <tr>
                <th>주문 여부</th>
                <td>
                    <c:if test="${order.result == '1'}">주문 전</c:if>
                    <c:if test="${order.result == '2'}">주문 완료</c:if>
                </td>
            </tr>
        </table>
        <div id="buttons">
            <input type="button" value="목록" class="btn"  onclick="location.href='NonageServlet?command=admin_order_list'">
        </div>
    </div>
</article>

<%@ include file="../footer.jsp" %>
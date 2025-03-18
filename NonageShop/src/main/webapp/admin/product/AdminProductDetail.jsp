<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<article>
    <div>
        <h2>상품 상세 보기</h2>
        <table id="detail">
            <tr>
                <th>상품분류</th>
                <td colspan="5">
                    <c:if test="${product.kind == '1'}">Heel</c:if>
                    <c:if test="${product.kind == '2'}">Boots</c:if>
                    <c:if test="${product.kind == '3'}">Sandals</c:if>
                    <c:if test="${product.kind == '4'}">Sneakers</c:if>
                    <c:if test="${product.kind == '5'}">Sneakers</c:if>
                    <c:if test="${product.kind == '6'}">Golden Goose</c:if>
                </td>
            </tr>
            <tr>
                <th>상품명</th>
                <td colspan="5">${product.name}</td>
            </tr>
            <tr>
                <th>원가 [A]</th>
                <td>${product.price1}</td>
                <th>판매가 [B]</th>
                <td>${product.price2}</td>
                <th>[B-A]</th>
                <td>${product.price2-product.price1}</td>
            </tr>
            <tr>
                <th>상세설명</th>
                <td colspan="5">${product.content}</td>
            </tr>
            <tr>
                <th>상품이미지</th>
                <td colspan="5"><img src="product_images/${product.image}"></td>
            </tr>
        </table>
        <div id="buttons">
            <input type="button" value="수정" class="btn"  onclick="location.href='NonageServlet?command=admin_product_update_form&pseq=${product.pseq}'">
            <input type="button" value="목록" class="btn"  onclick="location.href='NonageServlet?command=admin_product_list'">
        </div>
    </div>
</article>

<%@ include file="../footer.jsp" %>
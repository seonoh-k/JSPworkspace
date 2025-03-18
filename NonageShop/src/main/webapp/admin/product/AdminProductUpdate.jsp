<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="admin/script/admin.js"></script>
<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<article>
    <div>
        <h2>상품수정</h2>
        <form method = "post" action = "NonageServlet?command=admin_product_update">
            <input type="hidden" name="pseq" value="${product.pseq}">
            <table id="update">
                <tr>
                    <th>상품분류</th>
                    <td colspan="5">
                        <select name="kind">
                            <option value="1" <c:if test="${product.kind == '1'}">selected</c:if>>Heel</option>
                            <option value="2" <c:if test="${product.kind == '2'}">selected</c:if>>Boots</option>
                            <option value="3" <c:if test="${product.kind == '3'}">selected</c:if>>Sandals</option>
                            <option value="4" <c:if test="${product.kind == '4'}">selected</c:if>>Sneakers</option>
                            <option value="5" <c:if test="${product.kind == '5'}">selected</c:if>>Sneakers</option>
                            <option value="6" <c:if test="${product.kind == '6'}">selected</c:if>>Golden Goose</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td colspan="5" id="name"><input type="text" name="name" value="${product.name}"></td>
                </tr>
                <tr>
                    <th>원가 [A]</th>
                    <td><input type="text" name="price1" id="price1" value="${product.price1}" oninput="calculateDifference()"></td>
                    <th>판매가 [B]</th>
                    <td><input type="text" name="price2" id="price2" value="${product.price2}" oninput="calculateDifference()"></td>
                    <th>[B-A]</th>
                    <td><input type="text" name="price3" id="price3" value="${product.price2-product.price1}"></td>
                </tr>
                <tr>
                    <th>상세설명</th>
                    <td colspan="5"><textarea cols="50" rows="5" name="content" value="">${product.content}</textarea></td>
                </tr>
                <tr>
                    <th>베스트상품</th>
                    <td><input type="checkbox" name="bestyn" value="y" <c:if test="${product.bestyn == 'y'}">checked</c:if>></td>
                    <th>사용유무</th>
                    <td><input type="checkbox" name="useyn" value="y" <c:if test="${product.useyn == 'y'}">checked</c:if>></td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td colspan="5">
                        <img src="product_images/${product.image}"><br>
                        <input type="file" name="image" value="${product.image}">
                    </td>
                </tr>
            </table>
            <div id="buttons">
                <input type="submit" value="수정" class="btn">
                <input type="button" value="목록" class="btn"  onclick="location.href='NonageServlet?command=admin_product_list'">
            </div>
        </form>
    </div>
</article>
<%@ include file="../footer.jsp" %>
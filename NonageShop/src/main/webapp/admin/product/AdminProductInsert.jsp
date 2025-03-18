<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="admin/script/admin.js"></script>
<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<article>
    <div>
        <h2>상품등록</h2>
        <form method = "post" action = "NonageServlet?command=admin_product_insert">
            <table id="update">
                <tr>
                    <th>상품분류</th>
                    <td colspan="5">
                        <select name="kind">
                            <option value="1">Heel</option>
                            <option value="2">Boots</option>
                            <option value="3">Sandals</option>
                            <option value="4">Sneakers</option>
                            <option value="5">Sneakers</option>
                            <option value="6">Golden Goose</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td colspan="5" id="name"><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>원가 [A]</th>
                    <td><input type="text" name="price1" id="price1" oninput="calculateDifference()"></td>
                    <th>판매가 [B]</th>
                    <td><input type="text" name="price2" id="price2" oninput="calculateDifference()"></td>
                    <th>[B-A]</th>
                    <td><input type="text" name="price3" id="price3" readonly></td>
                </tr>
                <tr>
                    <th>상세설명</th>
                    <td colspan="5"><textarea cols="50" rows="8" name="content"></textarea></td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td colspan="5">
                        <img src="images/byeong-geon.png"><br>
                        <input type="file" name="image">
                    </td>
                </tr>
            </table>
            <div id="buttons">
                <input type="submit" value="등록" class="btn">
                <input type="button" value="목록" class="btn"  onclick="location.href='NonageServlet?command=admin_product_list'">
            </div>
        </form>
    </div>
</article>

<%@ include file="../footer.jsp" %>
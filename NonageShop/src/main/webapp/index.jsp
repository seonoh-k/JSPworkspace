<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="../header.jsp"%>

<div class="clear"></div>
<div id="main_img">
  <img src="images/main_img.jpg" >
</div>
<div class="clear"></div>

<div id="front">
    <h2> New Item</h2>
    <div id="bestProduct">
        <c:forEach var="product" items="${newProductList}">
            <div id="item">
                <a href="NonageServlet?command=product_detail&pseq=${product.pseq}">
                <img src="product_images/${product.image}" />
                <h3> ${product.name} </h3>
                <p>${product.price2}</p>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="clear"></div>

    <h2> Best Item</h2>
    <div id="bestProduct">
        <c:forEach var="product" items="${bestProductList}">
            <div id="item">
                <a href="NonageServlet?command=product_detail&pseq=${product.pseq}">
                <img src="product_images/${product.image}" />
                <h3> ${product.name} </h3>
                <p>${product.price2}</p>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="clear"></div>
</div>

<%@ include file="../footer.jsp"%>
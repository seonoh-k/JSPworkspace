<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

<article>
    <h2> Item</h2>
    <c:forEach var="product" items="${productList}">
      <div id="item">
        <a href="NonageServlet?command=product_detail&pseq=${product.pseq}">
          <img src="product_images/${product.image}" />
          <h3> ${product.name} </h3>
          <p> ${product.price2} </p>
        </a>
      </div>
    </c:forEach>
    <div class="clear"></div>
</article>

<%@ include file="../footer.jsp"%>
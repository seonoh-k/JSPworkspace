<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>
<article>
    <h1> Item </h1>
    <div id="itemdetail" >
        <form  method="post" name="formm">
            <fieldset>
                <legend> Item detail Info</legend>
                <a href="">
                    <span style="float: left;">
                      <img  src="product_images/${product.image}"  />
                    </span>
                    <h2> ${product.name} </h2>
                </a>
                <label> 가 격 :  </label>
                <p> ${product.price2} 원</p>
                <label> 수 량 : </label>
                <input  type="text"      name="quantity"  size="2"      value="1"><br>
                <input  type="hidden"    name="pseq"       value="${product.pseq}"><br>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <input type="button" value="장바구니에 담기"   class="submit"    onclick="go_cart()">
                <input type="button" value="즉시 구매"       class="submit"    onclick="go_order()">
                <input type="reset"  value="취소"           class="cancel">
            </div>
        </form>
    </div>
</article>

<%@ include file="../footer.jsp"%>
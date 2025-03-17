<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    int nowpage = ((Integer)request.getAttribute("page")).intValue();
    int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
    int startpage = ((Integer)request.getAttribute("startpage")).intValue();
    int endpage = ((Integer)request.getAttribute("endpage")).intValue();
    int listcount = ((Integer)request.getAttribute("listcount")).intValue();
%>

<%@ include file="../header.jsp" %>
<%@ include file="../sub_menu.jsp" %>

<article>
    <div id="wrap" align="center">
        <h3> 상품리스트 </h3>
        <div>
            <form method = "post" action = "NonageServlet?command=admin_product_search">
                <label>상품명</label>
                <input type="text" name="name" size="30">
                <div id="buttons">
                    <input type="submit" value="검색">
                    <input type="button"  value="전체보기"  class="submit"  onclick="location.href='NonageServlet?command=admin_product_list'">
                    <input type="button"  value="상품등록"  class="submit"  onclick="location.href='NonageServlet?command=admin_product_insert'">
                </div>
            </form>
        </div>
        <table>
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>원가</th>
                <th>판매가</th>
                <th>등록일</th>
                <th>사용유무</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.pseq}</td>
                    <td><a href="NonageServlet?command=admin_product_detail&name=${product.name}">${product.name}</a></td>
                    <td>${product.price1}</td>
                    <td>${product.price2}</td>
                    <td><fmt:formatDate value="${price.indate}" type="date"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${product.useyn.equals('y')}">사용</c:when>
                            <c:otherwise>미사용</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            <tr align="center" height=20>
                <td colspan="5" style="font-family:Tahoma;font-size:10pt">
                    <%
                        if(nowpage <= 1) {%>
                            [이 전]&nbsp;&nbsp;
                        <%}else {%>
                            <a href="./NonageServlet?command=admin_product_list&page=<%=nowpage-1%>">[이 전]</a>
                        <%}
                    %>
                    <%
                        for(int num=startpage;num<=endpage;num++) {
                            if(num == nowpage) {%>
                                [<%= num %>]
                            <%}else {%>
                                <a href="./NonageServlet?command=admin_product_list&page=<%=num%>">&nbsp;[<%= num %>]&nbsp;</a>
                            <%}
                        }
                    %>
                    <%
                        if(nowpage >= maxpage) {%>
                            &nbsp;&nbsp;[다 음]
                        <%}else {%>
                            <a href="./NonageServlet?command=admin_product_list&page=<%=nowpage+1%>">[다 음]</a>
                        <%}
                    %>
                </td>
            </tr>
        </table>
    </div>
</article>

<%@ include file="../footer.jsp" %>
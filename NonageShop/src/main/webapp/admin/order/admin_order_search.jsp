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
    <div>
        <h1> 주문리스트 </h1>
        <div id="search">
            <form method = "post" action = "NonageServlet?command=admin_order_search">
                <label>상품명</label>
                <input type="text" name="pname" size="30">
                <input type="submit" class="btn" value="검색">
                <input type="button"  value="전체보기"  class="btn"  onclick="location.href='NonageServlet?command=admin_order_list'">
            </form>
        </div>
        <table id="list">
            <tr>
                <th>주문번호</th>
                <th>상품번호</th>
                <th>상품명</th>
                <th>수량</th>
                <th>판매가</th>
                <th>주문자명</th>
                <th>등록일</th>
                <th>주문유무</th>
            </tr>
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td>${order.oseq}</td>
                    <td>${order.pseq}</td>
                    <td><a href="NonageServlet?command=admin_order_detail&oseq=${order.oseq}">${order.pname}</a></td>
                    <td>${order.quantity}</td>
                    <td>${order.price2}</td>
                    <td>${order.mname}</td>
                    <td><fmt:formatDate value="${order.indate}" type="date"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.result == '1'}">주문 완료</c:when>
                            <c:otherwise>주문 전</c:otherwise>
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
                            <a href="./NonageServlet?command=admin_order_list&page=<%=nowpage-1%>">[이 전]</a>
                        <%}
                    %>
                    <%
                        for(int num=startpage;num<=endpage;num++) {
                            if(num == nowpage) {%>
                                [<%= num %>]
                            <%}else {%>
                                <a href="./NonageServlet?command=admin_order_list&page=<%=num%>">&nbsp;[<%= num %>]&nbsp;</a>
                            <%}
                        }
                    %>
                    <%
                        if(nowpage >= maxpage) {%>
                            &nbsp;&nbsp;[다 음]
                        <%}else {%>
                            <a href="./NonageServlet?command=admin_order_list&page=<%=nowpage+1%>">[다 음]</a>
                        <%}
                    %>
                </td>
            </tr>
        </table>
    </div>
</article>

<%@ include file="../footer.jsp" %>
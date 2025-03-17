<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

<article>
    <h2> 1:1 고객 게시판 </h2>
    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
    <form name="formm" method="post">
    <c:choose>
        <c:when test="${qnaList.size() == 0}">
            <h3 style="color: red; text-align: center">문의내역이 없습니다</h3>
        </c:when>
        <c:otherwise>
            <table id="cartList">
                <tr>
                    <th>번호</th> <th>제목</th> <th>등록일</th> <th>답변 여부</th>
                </tr>
                <c:forEach var="qna" items="${qnaList}">
                <tr>
                    <td> ${qna.qseq} </td>
                    <td> <a href="NonageServlet?command=qna_view&qseq=${qna.qseq}"> ${qna.subject} </td>
                    <td> <fmt:formatDate value="${qna.indate}" type="date"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${qna.rep==1}">no</c:when>
                            <c:when test="${qna.rep==2}">yes</c:when>
                        </c:choose>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
        <div class="clear"></div>
        <div id="buttons" style="float:right">
        <input type="button"  value="1:1 질문하기"  class="submit" onclick="location.href='NonageServlet?command=qna_write_form'">
        <input type="button"    value="쇼핑 계속하기"  class="cancel" onclick="location.href='NonageServlet?command=index'">
        </div>
    </form>
</article>

<%@ include file="../footer.jsp"%>
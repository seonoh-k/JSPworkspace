<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
    <h2>Q&A 게시글 리스트</h2>
        <table id="list">
            <tr>
                <th>번호(답변여부)</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            <c:forEach var="qna" items="${qnaList}">
                <tr>
                    <td>
                        ${qna.qseq}
                        <c:if test="${qna.rep != null && qna.rep == '1'}">(미처리)</c:if>
                        <c:if test="${qna.rep != null && qna.rep == '2'}">(답변처리완료)</c:if>
                    </td>
                    <td>
                        <c:if test="${qna.rep != null && qna.rep == '2'}">
                            <a href="NonageServlet?command=admin_qna_detail&qseq=${qna.qseq}">${qna.subject}</a>
                        </c:if>
                        <c:if test="${qna.rep != null && qna.rep == '1'}">
                            <a href="NonageServlet?command=admin_qna_insertReply_form&qseq=${qna.qseq}">${qna.subject}</a>
                        </c:if>
                    </td>
                    <td>${qna.id}</td>
                    <td><fmt:formatDate value="${qna.indate}" type="date"/></td>
                </tr>
            </c:forEach>
        </table>
</article>

<%@ include file="../footer.jsp" %>
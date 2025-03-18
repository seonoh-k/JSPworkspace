<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>Q&amp;A 게시판</h1>
<form id="frm" name="frm" method="post" action="NonageServlet?command=admin_qna_insertReply">
    <input type="hidden" name="qseq" value="${qnaVO.qseq}">
    <table id="qnaDetail">
        <tr>
            <th>제목</th>
            <td>${qnaVO.subject}</td>
        </tr>
        <tr>
            <th>등록일</th>
            <td><fmt:formatDate value="${qnaVO.indate}" pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${qnaVO.content}</td>
        </tr>
        <tr>
            <th>댓글</th>
            <td>
                <textarea name="reply" rows="4" cols="50" placeholder="답글을 입력하세요"></textarea>
            </td>
        </tr>
    </table>

    <!-- 버튼 영역 -->
    <div id="buttons">
        <input type="button" value="목록" class="btn" onclick="location.href='NonageServlet?command=admin_qna_list'">
        <input type="submit" class="btn" value="저장">
    </div>
</form>
</article>
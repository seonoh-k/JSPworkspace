<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Board.DTO.BoardDetailDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="Comment.DTO.CommentDTO" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ArrayList<BoardDetailDTO> boardDetailList = (ArrayList<BoardDetailDTO>)request.getAttribute("boardDetailList");
    BoardDetailDTO board = boardDetailList.get(0);
    String date = (board.getB_update_at() == null) ? sdf.format(board.getB_create_at()) : sdf.format(board.getB_update_at());
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../script/writeComment.js"></script>
    <style>
        table {
            width : 1000px;
        }
        table th {
            height : 20px;
        }
        button {
            float : right;
        }
        .content {
            width : 100%;
            height : 200px;
        }
    </style>
    <title><%= board.getTitle() %></title>
</head>
<body>

    <table border="1">
        <tr>
            <th><%= board.getB_user_id() %></th>
            <th><%= board.getTitle() %></th>
            <th><%= date %>
            <%
                String sessionId = (String)session.getAttribute("id");
                if(sessionId != null && sessionId.equals(board.getB_user_id())) {
            %>
            <button onclick="javascript:if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteBoardProcess.jsp?board_no=<%= board.getBoard_no() %>'">삭제</button>
            <button onclick="location.href='SelectMyBoardProcess.jsp?board_no=<%= board.getBoard_no() %>'">수정</button>
            <%
                }
            %>
            </th>
        </tr>
        <tr>
            <td class="content" colspan="3"><%= board.getB_content() %></td>
        </tr>
        <%
            int boardNo = board.getBoard_no();
            request.setAttribute("board_no", board.getBoard_no());
        %>
        <tr>
            <td colspan="3"><jsp:include page="WriteComment.jsp"/></td>
        </tr>
        <tr>
            <th>작성자</th>
            <th>댓글</th>
            <th>작성시간</th>
        </tr>
        <%
            if (board.getC_create_at() != null) {
                for (int i=0; i<boardDetailList.size(); i++) {
                    BoardDetailDTO comment = boardDetailList.get(i);
                    String commentDate = (comment.getC_update_at() == null) ? sdf.format(comment.getC_create_at()) : sdf.format(comment.getC_update_at());
                    request.setAttribute("comment_no", comment.getComment_no());
        %>
        <% if(comment.getRef() == 0) { %>
            <tr onclick="writeCoComment(<%=comment.getComment_no()%>, <%=boardNo%>)" id = "selectedComment<%=comment.getComment_no()%>">
                <td><%= comment.getC_user_id() %></td>
                <td><%= comment.getC_content() %></td>
                <td><%= commentDate %>
                <%
                    if(sessionId != null && sessionId.equals(comment.getC_user_id())) {
                %>
                    <button onclick="javascript:event.stopPropagation(); if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">삭제</button>
                    <button onclick="changeRow(<%=comment.getComment_no()%>, event)">수정</button>
                <% } %>
                </td>
            </tr>
            <tr id = "CoComment<%=comment.getComment_no()%>" style = "display : none">
                <td colspan="3" id = "writeCoComment<%=comment.getComment_no()%>"></td>
            </tr>
        <%}else {%>
            <tr onclick="writeCoComment(<%=comment.getComment_no()%>, <%=boardNo%>)">
                <td>↳<%= comment.getC_user_id() %></td>
                <td><%= comment.getC_content() %></td>
                <td><%= commentDate %>
                <%
                    if(sessionId != null && sessionId.equals(comment.getC_user_id())) {
                %>
                    <button onclick="changeRow(<%=comment.getComment_no()%>, event)">수정</button>
                    <button onclick="javascript:event.stopPropagation(); if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">삭제</button>
                <% } %>
                </td>
            </tr>
            <tr id = "CoComment<%=comment.getComment_no()%>" style = "display : none">
                <td colspan="3" id = "writeCoComment<%=comment.getComment_no()%>"></td>
            </tr>
            <% } %>
        <%
                }
            }
        %>
    </table>
</body>
</html>
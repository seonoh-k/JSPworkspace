<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Board.DTO.BoardDetailDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../script/writeComment.js"></script>
    <title></title>
</head>
<body>
    <table border="1">
        <%
            ArrayList<BoardDetailDTO> boardDetailList = (ArrayList<BoardDetailDTO>)request.getAttribute("boardDetailList");
            BoardDetailDTO board = boardDetailList.get(0);
            String date = (board.getB_update_at() == null) ? sdf.format(board.getB_create_at()) : sdf.format(board.getB_update_at());
        %>
        <tr>
            <th colspan=2><%= board.getTitle() %></th>
            <th><%= board.getB_user_id() %></th>
            <th><%= date %></th>
        </tr>
        <tr>
            <td colspan=4><%= board.getB_content() %></td>
        </tr>
        <%
            String sessionId = (String)session.getAttribute("id");
            if(sessionId != null && sessionId.equals(board.getB_user_id())) {
        %>
        <tr>
            <td><button onclick="location.href='SelectMyBoardProcess.jsp?board_no=<%= board.getBoard_no() %>'">수정</button></td>
            <td><button onclick="javascript:if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteBoardProcess.jsp?board_no=<%= board.getBoard_no() %>'">삭제</button></td>
        </tr>
        <%
            }
        %>
        <%
            int boardNo = board.getBoard_no();
            request.setAttribute("board_no", board.getBoard_no());
        %>
        <tr>
            <td><jsp:include page="WriteComment.jsp"/></td>
        </tr>
        <%
            if (board.getC_create_at() != null) {
                for (int i=0; i<boardDetailList.size(); i++) {
                    BoardDetailDTO comment = boardDetailList.get(i);
                    String commentDate = (comment.getC_update_at() == null) ? sdf.format(comment.getC_create_at()) : sdf.format(comment.getC_update_at());
                    request.setAttribute("comment_no", comment.getComment_no());
        %>
        <% if(comment.getRef() == 0) { %>
            <tr onclick="writeCoComment(<%=comment.getComment_no()%>, <%=boardNo%>)">
                <td><%= comment.getC_user_id() %></td>
                <td colspan=2><%= comment.getC_content() %></td>
                <td><%= commentDate %></td>
                <%
                    if(sessionId != null && sessionId.equals(comment.getC_user_id())) {
                %>
                    <td><button onclick="location.href='SelectMyCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">수정</button></td>
                    <td><button onclick="javascript:if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">삭제</button></td>
                <% } %>
            </tr>
            <tr id = "CoComment<%=comment.getComment_no()%>" style = "display : none">
                <td id = "writeCoComment<%=comment.getComment_no()%>"></td>
            </tr>
        <%}else {%>
            <tr onclick="writeCoComment(<%=comment.getComment_no()%>, <%=boardNo%>)">
                <td>↳</td>
                <td><%= comment.getC_user_id() %></td>
                <td colspan=2><%= comment.getC_content() %></td>
                <td><%= commentDate %></td>
                <%
                    if(sessionId != null && sessionId.equals(comment.getC_user_id())) {
                %>
                    <td><button onclick="location.href='SelectMyCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">수정</button></td>
                    <td><button onclick="javascript:if(confirm('정말 삭제하시겠습니까?')) location.href='DeleteCommentProcess.jsp?comment_no=<%= comment.getComment_no() %>'">삭제</button></td>
                <% } %>
            </tr>
            <tr id = "CoComment<%=comment.getComment_no()%>" style = "display : none">
                <td>↳</td>
                <td id = "writeCoComment<%=comment.getComment_no()%>"></td>
            </tr>
            <% } %>
        <%
                }
            }
        %>
    </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    try {

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        RequestDispatcher dis = request.getRequestDispatcher("/WriteBoardController");
        dis.forward(request, response);

    }catch(Exception e) {
        out.println("<html><body>");
        out.println("<script type='text/javascript'>");
        out.println("alert('게시글 작성에 실패했습니다.');");
        out.println("window.location.href = 'WriteBoard.jsp';");
        out.println("</script>");
        out.println("</body></html>");
    }


%>
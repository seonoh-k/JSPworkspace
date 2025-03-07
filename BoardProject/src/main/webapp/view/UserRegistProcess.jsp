<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    try {

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String usr_email = request.getParameter("user_email");
        String domain = request.getParameter("domain");
        String gender = request.getParameter("gender");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");


        RequestDispatcher dis = request.getRequestDispatcher("/UserRegistController");
        dis.forward(request, response);

    }catch(Exception e) {
        out.println("<html><body>");
        out.println("<script type='text/javascript'>");
        out.println("alert('회원가입에 실패했습니다. 다시 시도해주세요');");
        out.println("window.location.href = 'UserRegist.jsp';");
        out.println("</script>");
        out.println("</body></html>");
    }


%>
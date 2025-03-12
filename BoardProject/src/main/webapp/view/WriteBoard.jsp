<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%
    if (session.getAttribute("user_no") == null) {
                out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('먼저 로그인 해주세요.');");
                out.println("window.location.href = 'Login.jsp';");  // 로그인 페이지로 리디렉션
                out.println("</script>");
                out.println("</body></html>");
                return;
            }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
</head>
<body>
    <form method = "post" action = "WriteBoardProcess.jsp">
        <input type = "text" name = "title" id = "title">
        <input type = "submit" value = "등록"><br>
        <textarea name = "content" id = "content" placeholder="내용을 입력하세요" rows="4" cols="50"></textarea>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>

<%
    Connection conn = null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;

    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String id = "SCOTT";
    String pwd = "tiger";
    String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?)";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String userPwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String admin = request.getParameter("admin");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, id, pwd);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, userid);
            pstmt.setString(3, userPwd);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setInt(6, Integer.parseInt(admin));

            int result = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    %>
    <h3>회원 가입 성공</h3>
    <a href = "memberAll.jsp">회원 전체 목록 보기</a>
</body>
</html>

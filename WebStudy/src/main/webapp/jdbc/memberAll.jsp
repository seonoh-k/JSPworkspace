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
    String sql = "SELECT * FROM MEMBER";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <table width="800" border="1">
        <tr>
            <th>이름</th>
            <th>아이디</th>
            <th>암호</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>권한(1:관리자 2:일반회원)</th>
        </tr>
        <%
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, id, pwd);
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("userid") %></td>
            <td><%= rs.getString("pwd") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("phone") %></td>
            <td><%= rs.getInt("admin") %></td>
        </tr>
        <%
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>
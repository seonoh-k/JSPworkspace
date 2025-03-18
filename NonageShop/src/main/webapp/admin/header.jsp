<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="admin/css/admin.css" rel="stylesheet">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NonageShop ==Admin==</title>
</head>
<body>
<div id="wrap">
    <header>
        <div id="Logo">
            <h1><a href="NonageServlet?command=index">Nonage</a></h1>
            <c:if test="${admin != null}">
                <input type="button" class="submit" value="logout" onclick="location.href='NonageServlet?command=admin_logout'">
            </c:if>
        </div>
    </header>
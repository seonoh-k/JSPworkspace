<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<% String item = request.getParameter("page");
    if(item == null) {
        item = "newitem";
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <table width="968" border="1" color="gray" align=center>
        <tr>
            <td height="43" colspan=3 align=left>
                <jsp:include page="header.jsp"/>
            </td>
        </tr>

        <tr>
            <td width="15%" align=right valign=top>
                <jsp:include page="menu.jsp"/>
            </td>
            <td colspan=2 align=center>
                <jsp:include page= '<%=item + ".jsp"%>'/>
            </td>
        </tr>

        <tr>
            <td width=100% height=43 colspan=3>
                <jsp:include page="footer.jsp"/>
            </td>
        </tr>
    </table>
</body>
</html>
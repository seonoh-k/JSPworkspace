<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    String popupMode = "on";

    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        String cookieName = c.getName();
        String cookieValue = c.getValue();

        if(cookieName.equals("PopupClose")) {
            popupMode = cookieValue;
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        div#popup{
            position: absolute; top:100px; left:100px; color:yellow;
            width:300px; height:100px; background-color:gray;
        }
        div#popup>div{
            position: relative; background-color:#ffffff; top:0px;
            border:1px solid gray; padding:10px; color:black;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(function() {
        $('#closeBtn').click(
            function() {
                $('#popup').hide();
                let chkVal = $('input:checkbox[id=inactiveToday]:checked').val();
                $.ajax({
                    url : './PopupCookie.jsp',
                    type : 'get',
                    data : {inactiveToday : chkVal},
                    datatype : 'text',
                    success : function(data) {
                        if(data != '') {
                            location.reload();
                        }
                    }
                });
            }
        );
    });

    </script>
</head>
<body>
<% if(popupMode.equals("on")) { %>
    <div id="popup">
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right"><form name="popFrm">
            <input type="checkbox" id="inactiveToday" value="1" />
            하루 동안 열지 않음
            <input type="button" value="닫기" id="closeBtn" />
        </form></div>
    </div>
<% } %>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome in my hotel!</title>
    </head>
    <body>
        <%@include file="login.jsp"%>
        <%@include file="menu.jsp"%>
        <a href ="admin.jsp">
        <a href="<c:url value='/actions/admin'/>" >Админ</a>
    </body>
</html>
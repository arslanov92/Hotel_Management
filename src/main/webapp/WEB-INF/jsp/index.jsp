<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome in my hotel!</title>
    </head>
    <body>
        <%@include file="login.jsp"%>
        <%@include file="menu.jsp"%>  
        <!--a href="<c:url value='/private/login'/>" >login</a -->
        <a href="<c:url value='/private/admin'/>" >Админ</a>
    </body>
</html>

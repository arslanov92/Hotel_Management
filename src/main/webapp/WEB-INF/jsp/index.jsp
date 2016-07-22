<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome in my hotel!</title>
    </head>    
        <body><%@include file="login.jsp"%>
        <ul id="index">  
            <li><a href="<c:url value='lookUpRooms'/>">Посмотреть свободные комнаты </a></li> 
            <li><a href="<c:url value='/private/admin'/>"> Админ</a></li>
            <li><a href="<c:url value='webService'/> ">Web service псмотреть свободные комнаты</a></li>
        </ul>
    </body>
</html>

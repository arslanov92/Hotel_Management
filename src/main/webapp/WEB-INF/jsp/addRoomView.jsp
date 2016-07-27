<%-- 
    Document   : addRoomView
    Created on : 27.07.2016, 20:20:27
    Author     : Марат
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <%@include file="admin.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <ul id="reg">                    
            <form method="post" action="<c:url value='/private/addRoom'/>"> 
                <li> Добавить комнату</li>
                <li> Введите номер комнаты:</li>
                <li> <input name="roomNumber" value="11" required="" pattern="[0-9]{1,1000}"/> </li>                                                
                <li> Введите тип комнаты:</li>
                <li> <input name="typeRoom" name="Standart" required="" pattern="[А-Яа-яA-Za-z]{1,1000}"/></li>                                 
                <li> Введите количество спальных мест:</li>
                <li> <input name="bed" value="2" required="" pattern="[0-9]{1,1000}"/></li>
                <li> Введите цену:</li>
                <li> <input name="price" value="250" required="" pattern="[0-9]{1,1000}" /></li>                     
        </ul>
        <input type=submit value="Отправить" id="button"/>
    </body>
</html>

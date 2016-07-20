<%-- 
    Document   : lookHystory
    Created on : 12.07.2016, 18:32:25
    Author     : Марат
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
<body>
    <h2> <a href="index">На главную!</a> </h2>
        <h1>История вашего бронирования</h1>
        <p>Введите дату заселения  Введите дату выселения </p>        
        <p>Cвободные комнаты: </p>        
        <table>        
            <thead>
                <tr>
                    <th>  </th>
                    <th> Дата заселения </th>
                    <th> Дата выезда </th>
                    <th> Номер комнаты </th>
                    <th> Тип комнаты </th>
                    <th> Количество спальных мест </th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="X" items="${hystory}">
                    <tr>
                        <td>               
                        <td>${X.chekDate}</td>
                        </td>                
                        <td>${X.chekOutDate}</td>
                        <td>${X.holderRoom.roomNumber}</td>
                        <td>${X.holderRoom.typeRoom}</td>
                        <td>${X.holderRoom.bed}</td>
                    </tr>            
                </c:forEach>       
            </tbody>             
        </table>
    </body>

</html>

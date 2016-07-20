<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<html>    
    <body>
        <h2> <a href="admin">На admin!</a> </h2>
        <h1>Список комнат</h1>
        <table>        
        <thead>
        <tr>
        <th>  </th>
        <th> id комнаты </th>
        <th> Номер комнаты </th>
        <th> Тип номера </th>
        <th> Количество спальных мест </th>
        <th> Цена за день </th>
        </tr>
        </thead>    
        <tbody>
        <form method="post" action="<c:url value='/private/delRoom'/>">
        <c:forEach var="X" items="${rooms}">
            <tr>                
                <td>
                <input type="radio" name="roomId" value="${X.roomId}"  /> 
                <td>${X.roomId}</td> 
                </td>
                <td>${X.roomNumber}</td>
                           
                <td>${X.typeRoom}</td>
                <td>${X.bed}</td>
                <td>${X.price}</td>  
            </tr>            
        </c:forEach>       
        </tbody>             
    </table>
        <p><input type="submit" value="Удалить комнату"></p>       
    </body>
    </form>
</html>

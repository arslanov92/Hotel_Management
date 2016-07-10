<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>        
        
    <table>   
        Забронировать комнату с ${chekDate} по ${chekOutDate} 
        <thead>
        <tr>
        <th>  </th>
        <th> Номер комнаты </th>
        <th> Тип номера </th>
        <th> Количество спальных мест </th>
        <th> Цена за день </th>
        </tr>
        </thead>    
        <tbody>
        <form action="reservationFinal">
        <input hidden="true" type="date" value="${chekDate}" name="chekDate"/>
        <input hidden="true" type="date" value="${chekOutDate}" name="chekOutDate"/>
        <c:forEach var="X" items="${rooms}">
            <tr>
                <td>               
                <input type="radio" name="roomId" value="${X.roomId}"  /> 
                <td>${X.roomNumber}</td>
                </td>                
                <td>${X.typeRoom}</td>
                <td>${X.bed}</td>
                <td>${X.price}</td>                
            </tr>            
        </c:forEach>       
        </tbody>  
        
    </table>
        <p><input type="submit" value="забронировать"></p>
    </body>
    </form>
</html>

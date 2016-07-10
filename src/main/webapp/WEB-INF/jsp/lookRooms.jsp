<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>    
    <body>
        <h1>Список комнат</h1>
        <table>        
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
        <c:forEach var="X" items="${rooms}">
            <tr>
                <td>               
                <td>${X.roomNumber}</td>
                </td>                
                <td>${X.typeRoom}</td>
                <td>${X.bed}</td>
                <td>${X.price}</td>  
                <td>${X.price}</td>
            </tr>            
        </c:forEach>       
        </tbody>             
    </table>
    </body>
</html>

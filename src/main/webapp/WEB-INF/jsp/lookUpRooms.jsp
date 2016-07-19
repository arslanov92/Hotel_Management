<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <body>
        <a href="index">На главную!</a>
        <h1>Найти свободные комнаты</h1>
        <p>Введите дату заселения  Введите дату выселения </p>
        <form action="lookUpRooms">
            <p><input type="date" name="calendar1"> <input type="date" name="calendar2"></p>
            <p><input type="submit"></p>
        </form>
        <p>Cвободные комнаты: </p>        
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
                    </tr>            
                </c:forEach>       
            </tbody>             
        </table>
    </body>

</html>

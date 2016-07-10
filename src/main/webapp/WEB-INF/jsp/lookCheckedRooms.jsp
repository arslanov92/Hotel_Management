<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <body>
        <h1>Посмотреть зарезервированные комнаты</h1>
    <p>Введите дату заселения  Введите дату выселения </p>
    <form action="lookCheckedRooms">
    <p><input type="date" name="calendar1"> <input type="date" name="calendar2"></p>
    <p><input type="submit"></p>
    </form>
        <p>Зарезервированные комнаты: </p>      
    <table>        
        <thead>
        <tr>
        <th>  </th>
        <th> Номер комнаты </th>
        <th> Тип номера </th>
        <th> Количество спальных мест </th>
        <th> Цена за день </th>
        <th> Зарезервировал с </th>
        <th> Зарезервировал до </th>
        <th> Имя клиента </th>
        <th> Фамилия клиента </th>
        <th> Логин клиента </th>
        </tr>
        </thead>    
        <tbody>
        <c:forEach var="X" items="${checkRooms}">
            <tr>
                <td>               
                <td>${X.holderRoom.roomNumber}</td>
                </td>                
                <td>${X.holderRoom.typeRoom}</td>
                <td>${X.holderRoom.bed}</td>
                <td>${X.holderRoom.price}</td>
                <td>${X.chekDate}</td>
                <td>${X.chekOutDate}</td>
                <td>${X.holderUser.firstName}</td>   
                <td>${X.holderUser.lastName}</td>  
                <td>${X.holderUser.login}</td>                 
            </tr>            
        </c:forEach>       
        </tbody>             
    </table>
    </body>
</html>
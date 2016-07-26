<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
<body>
    <h2> <a href="index">На главную!</a> </h2>       
        <h1>Какую бронь вы хотети отменить?</h1>       
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
                <form method="post" action="<c:url value='/actions/cancelResDo'/>">
                
                <c:forEach var="X" items="${checkRoom}">
                    <tr>
                        <td> 
                            <input type="radio" name="roomId" value="${X.holderRoom.roomId}"  /> 
                        <td>${X.chekDate}</td>
                        </td>                
                        <td>${X.chekOutDate}</td>
                        <td>${X.holderRoom.roomNumber}</td>
                        <td>${X.holderRoom.typeRoom}</td>
                        <td>${X.holderRoom.bed}</td>
                        <input hidden="true" type="date" value="${X.chekDate}" name="chekDate"/>
                        <input hidden="true" type="date" value="${X.chekOutDate}" name="chekOutDate"/>
                    </tr>            
                </c:forEach>       
            </tbody>             
        </table>
        <p><input type="submit" value="Отменить бронь"></p>    
    </body>
        </form>
</html>
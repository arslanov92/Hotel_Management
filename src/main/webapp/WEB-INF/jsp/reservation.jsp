
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <a href="index">На главную!</a>
    <body>
    <h1>Найти свободные комнаты</h1>
    <p>Введите дату заселения  Введите дату выселения </p>
    
    <form action="reservation">
    <p><input type="date" name="calendarRe"> <input type="date" name="calendarRe2"></p>
    <p><input type="submit"></p>
    </form>             
    
    </body>
    <%@include file="reservationDo.jsp"%>
</html>

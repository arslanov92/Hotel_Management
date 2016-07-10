<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <body>
        
        <ul>
            <h1>Комнаты</h1>
            <li><a href="<c:url value='/actions/lookRooms'/>" >Посмотреть комнаты</a></li>
            <li><a href="<c:url value='/actions/lookCheckedRooms'/>">Посмотреть зарезервированные комнаты</a></li>
            <li>Добавить комнату</li>
            <li>Удалить комнату</li>
        </ul>
        <ul>
            <h1>Пользователи</h1>
            <li>Посмотреть пользователей</li>
            <li>Добавить пользователя</li>
            <li>Удалить пользователя</li>
        </ul>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <body>
        
        <h1>${msgDelUserFirstName} ${msgDelUserLastName} ${msgDelUserSuc}</h1>
        <h1>${msgDelRoomSuc}</h1>
        <h1> ${msgSuccessful}</h1>
        <h1>${msg}</h1>
        <h1>${details}</h1>
        <ul id="navbar">
            <li><a href="<c:url value='/private/lookRooms'/>" >Посмотреть комнаты</a></li>
            <li><a href="<c:url value='/private/addRoomView'/>" >Добавить комнату</a></li>
            <li><a href="<c:url value='/private/lookCheckedRooms'/>">Посмотреть зарезервированные комнаты</a></li>
            <li><a href="<c:url value='/private/lookUsers'/>" >Посмотреть пользователей</a></li>  
            
        </ul>         
            <h2> <a href="index">На главную!</a> </h2>
    </form>  
</body>
</html>

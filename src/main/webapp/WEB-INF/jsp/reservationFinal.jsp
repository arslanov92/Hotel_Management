
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <body>
        
        <h1>${user.firstName} ${user.lastName} поздравляем!</h1>
        Вы забронировали комнату № ${room.roomNumber} <br> Тип ${room.typeRoom} <br> Спальных мест: ${room.bed} 
        <br> Стоимость проживания ${room.price} <br>
        <a href="index">На главную!</a>
    </body>
</html>

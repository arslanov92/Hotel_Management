<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <body>
            <a href="index">На главную!</a>
        <ul>
            <h1>Комнаты</h1>
            <li><a href="<c:url value='/private/lookRooms'/>" >Посмотреть комнаты</a></li>
            <li><a href="<c:url value='/private/lookCheckedRooms'/>">Посмотреть зарезервированные комнаты</a></li>
            <li>Добавить комнату</li>
            <form method="post" action="<c:url value='/private/addRoom'/>">
                <tr>
                    <td>
                        <h1>${msg}</h1>
                        <h1>${details}</h1>
                        Введите номер комнаты:
                        <input name="roomNumber" value="11" />
                        <br>
                        <br>      
                    </td>
                    <td> 
                        Введите тип комнаты:
                        <input name="typeRoom" name="Standart"/>
                        <br>
                        <br>            
                    </td>
                    <td> 
                        Введите количество спальных мест:
                        <input name="bed" value="2" />
                        <br>
                        <br>
                    </td>
                    <td> 
                        Введите цену:
                        <input name="price" value="250" />
                        <br>
                        <br>            
                    </td>
                    <td>
                        <input type=submit value="Отправить" id="button"/>
                    </td>
                </tr>
                <h1> ${msgSuccessful}</h1>
            </form>            
            <li>Удалить комнату</li>
            <form method="post" action="<c:url value='/private/delRoom'/>">
            <tr>
                <td>                        
                        Введите id комнаты:
                        <input name="roomId" value="" />
                        <br>     
                    </td>
                    <td>
                        <input type=submit value="Отправить" id="button"/>
                    </td>
            </tr>
           ${msgDelRoomSuc}
            </form>      
        </ul>
        <ul>
            
            <h1>Пользователи</h1>
            <li><a href="<c:url value='/private/lookUsers'/>" >Посмотреть пользователей</a></li>                                   
            <li>Удалить пользователя</li>
            <form method="post" action="<c:url value='/private/delUser'/>">
            <tr>
                <td>
                        Введите id пользователя:
                        <input name="userId" value="" />
                        <br>     
                    </td>
                    <td>
                        <input type=submit value="Отправить" id="button"/>
                    </td>
            </tr>
            ${msgDelUserSuc}
            </form>      
        </ul>
    </body>
</html>

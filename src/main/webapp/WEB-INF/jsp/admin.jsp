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
            <form method="post" action="<c:url value='/actions/addRoom'/>">
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
                        <input type=submit value="Отправить"/>
                    </td>
                </tr>
                <h1> ${msgSuccessful}</h1>
            </form>            
            <li>Удалить комнату</li>
            <form method="post" action="<c:url value='/actions/delRoom'/>">
            <tr>
                <td>
                        <h1>${msg}</h1>
                        <h1>${details}</h1>
                        Введите id комнаты:
                        <input name="roomId" value="" />
                        <br>
                        <br>      
                    </td>
            </tr>
            </form>      
        </ul>
        <ul>
            <h1>Пользователи</h1>
            <li>Посмотреть пользователей</li>
            <li>Добавить пользователя</li>
            <li>Удалить пользователя</li>
        </ul>
    </body>
</html>

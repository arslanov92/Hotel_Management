<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <table>
        <tbody>
            <c:choose>
                <c:when test="${sessionScope.name!=null}" >
                <ul>
                    Добро пожаловать,       
                    <li> ${sessionScope.name}</li>
                    <li> ${sessionScope.lastName}</li>
                    <li><a href="<c:url value='/actions/reservation'/>" > Забронировать</a></li> 
                    <li><a href="<c:url value='/actions/lookHystory'/>" > Посмотреть историю бронирования</a></li> 
                    <li><a href="<c:url value='/actions/logout'/>" > Выйти из системы</a> </li>

                </ul>

            </c:when>
            <c:otherwise>
                <form method="post" action="<c:url value='/actions/login'/>">
                    <ul>               
                        <li>Пользователь</li>
                        <input name="login" value="ivan92" />
                        <li>Пароль</li>
                        <input type="password" name="pwd" value="123" />
                        <input type=submit value="вход"/>

                    </ul>               

                </form>
                <a href="registration"> Зарегистрироваться</a>

            </c:otherwise>
        </c:choose>
        <tbody>
    </table>
</html>

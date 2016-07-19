<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>

<html>
    <table>
        <body>                    
            <c:choose>
                <c:when test="${sessionScope.name!=null}" >
                    <div>
                    <h1 >Добро пожаловать, ${sessionScope.name} ${sessionScope.lastName}</h1>
                <ul id="navbar">                    
                    <li ><a href="<c:url value='/actions/reservation'/>" > Забронировать</a></li> 
                    <li><a href="<c:url value='/actions/lookHystory'/>" > Посмотреть историю бронирования</a></li> 
                    <li><a href="<c:url value='/actions/logout'/>" > Выйти из системы</a> </li>
                </ul>
            </c:when>
            <c:otherwise>
                <form method="post" action="<c:url value='/actions/login'/>">
                    <ul id="navbar">               
                        <li>Пользователь</li>
                        <input name="login" value="ivan92" />
                        <li>Пароль</li>
                        <input type="password" name="pwd" value="123" />
                        <input type=submit value="вход" id="button" />
                        <li><a href="registration"> Зарегистрироваться</a></li>
                    </ul>               
                </form>                
            </c:otherwise>
        </c:choose>
        <body>
    </table>
</html>

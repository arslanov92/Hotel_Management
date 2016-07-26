
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <h2> <a href="index">На главную!</a> </h2>
    <div id="login">
   <form method="post" action="<c:url value='/actions/registrationDo'/>">
    <tr>
        <td>
            <h1>${msg}</h1>
            <br>
            ${details}   
            <br>
            <br>
            Введите логин:
            <input name="login" value="ivan" id="name" required="" pattern="[А-Яа-яA-Za-z0-9_-]{4,8}"/>
            <br>
            <br>      
        </td>
        <td> 
            Введите пароль:(Минимум 8, масимум 16 символов)
            <input type="password" name="pwd"  id="password" required="" pattern="[А-Яа-яA-Za-z0-9_-]{8,16}"/>
            <br>
            <br>            
        </td>
        <td> 
            Введите имя
            <input name="firstName" value="Ivan" />
            <br>
            <br>
        </td>
        <td> 
            Введите фамилию
            <input name="lastName" value="Ivanov" />
            <br>
            <br>            
        </td>
        <td>
            <input type=submit value="Отправить" id="button"/>
        </td>
    </tr>
    </form>
    </div>
</html>

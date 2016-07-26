<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>
    <h2> <a href="index">На главную!</a> </h2>
    <div id="login">
   <form method="post" action="<c:url value='/actions/registrationDo'/>">
    <ul id="reg">
        <li>
            <h1>${msg}</h1>            
            <h1>${details}</h1>               
            Введите логин:            
        </li>
        <li>
            <input name="login" value="ivan" id="name" required="" pattern="[А-Яа-яA-Za-z0-9_-]{4,8}"/>
        </li> 
         <br>
        <li> 
            Введите пароль:(Минимум 8, масимум 16 символов)                   
        </li>
        <li>
             <input type="password" name="pwd"  id="password" required="" pattern="[А-Яа-яA-Za-z0-9_-]{8,16}"/>
        </li> 
         <br>
        <li> 
            Введите имя          
        </li>
        <li>
              <input name="firstName" value="Ivan" />
        </li> 
         <br>
        <li> 
            Введите фамилию           
        </li>
        <li>
             <input name="lastName" value="Ivanov" />
        </li>
         <br>
        <li>
            <input type=submit value="Отправить" id="button"/>
        </li>
        <li>
        </li> 
    </ul>
    </form>
    </div>
</html>

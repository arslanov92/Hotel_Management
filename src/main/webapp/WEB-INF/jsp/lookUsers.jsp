<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<!DOCTYPE html>
<html>    
    <body>
        <a href="admin">На admin!</a>
        <h1>Список ползователей</h1>
        <table>        
        <thead>
        <tr>
        <th>  </th>
        <th> id пользователя </th>
        <th> Имя</th>
        <th> Фамилия </th>
        <th> Логин </th>
        </tr>
        </thead>    
        <tbody>
        <c:forEach var="X" items="${users}">
            <tr>
                <td>
                <td>${X.userId}</td> 
                </td>
                <td>${X.firstName}</td>
                           
                <td>${X.lastName}</td>
                <td>${X.login}</td>
            </tr>            
        </c:forEach>       
        </tbody>             
    </table>
    </body>
</html>

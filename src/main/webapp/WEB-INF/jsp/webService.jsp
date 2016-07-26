<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEb_service</title>    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="<c:url value='/resources/newjavascript.js'/>"></script>
    </head>
    <body>        
         <h1>${msg}</h1>
            <h2>${details} </h2>
        <h2> <a href="index">На главную!</a> <h2>
                <h1>Найти свободные комнаты</h1>
                <p>Введите дату заселения  Введите дату выселения </p>
                <form action="webService">
                    <p><input type="date" name="CheckDate"> <input type="date" name="CheckOutDate"></p>
                    <p><input type="button" onclick="example()" value="Отправить"></p>
                </form>
                <span></span>
    </body>
</html>

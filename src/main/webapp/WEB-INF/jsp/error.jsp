<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ошибка</title>
    </head>
    <body>

        
        <%@include file="index.jsp"%>

        <div class="error">
            <h1>${msg}</h1>
            <h2>${details} </h2>
        </div>
        <br/>
        <a href="javascript:history.back()">Назад</a>
</body>
</html>


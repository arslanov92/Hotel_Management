<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value='/resources/style.css'/>" rel="stylesheet" type="text/css" media="screen" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ошибка</title>
    </head>
    <body>

        <%@include file="login.jsp"%>
        <%@include file="menu.jsp"%>

        <div class="error">
            <h1>${msg}</h1>
            ${details}
        </div>
        <br/>
        <a href="javascript:history.back()">Назад</a>
</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить</title>
</head>
<body>
<h2>Изменить</h2>
<c:set value="${order}" var="order"/>
<spring:form action="update" id="updateForm" method="post">
    <input type="hidden" name="id" value="${order.id}">
    Артикул: <input type="text" value="<c:out value='${order.article}' />" name="article"><br/>
    Стоимость: <input type="text" value="<c:out value='${order.cost}' />" name="cost"><br/>
    Длина: <input type="text" value="<c:out value='${order.length}' />" name="lenght"><br/>
    Ширина: <input type="text" value="<c:out value='${order.width}' />" name="width"><br/>
    Высота: <input type="text" value="<c:out value='${order.height}' />" name="height"><br/>
    <input type="submit" name="addOrder" value="Добавить"/>
</spring:form>
</body>
</html>

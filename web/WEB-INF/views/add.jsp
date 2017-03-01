<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добаввить заказ</title>
</head>
<body>
<h2>Добавить заказ</h2>
<spring:form action="add" id="addForm" method="post">
    Артикул: <input type="text" value="" name="article"><br/>
    Стоимость: <input type="text" value="" name="cost"><br/>
    Длина: <input type="text" value="" name="lenght"><br/>
    Ширина: <input type="text" value="" name="width"><br/>
    Высота: <input type="text" value="" name="height"><br/>
    <input type="submit" name="addOrder" value="Добавить"/>
</spring:form>
</body>
</html>

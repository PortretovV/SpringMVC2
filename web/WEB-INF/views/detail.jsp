<%@ page import="portvitaly.entity.Order" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подробнее</title>
</head>
<body>
<h2>Подробнее</h2>
<c:set value="${order}" scope="request" var="order"/>
<table style="border:  4px double black">
    <tbody>
        <tr><td>ID : </td><td><c:out value="${order.id}"/></td></tr>
        <tr><td>Артикул товара: </td><td><c:out value="${order.article}"/></td></tr>
        <tr><td>Стоимость : </td><td><c:out value="${order.cost}"/></td></tr>
        <tr><td>Длина : </td><td><c:out value="${order.length}"/></td></tr>
        <tr><td>Ширина : </td><td><c:out value="${order.width}"/></td></tr>
        <tr><td>Высота : </td><td><c:out value="${order.height}"/></td></tr>
    </tbody>
</table>
</body>
</html>

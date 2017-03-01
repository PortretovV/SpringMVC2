<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Список заказов</title>
  </head>
  <body>
  <h2>Все заказы</h2>
  <spring:form action="" modelAttribute="" method="post">

      <table style="border: 3px dotted black">
        <tr>
          <th>ID</th>
          <th> Артикул </th>
          <th> Стоимость </th>
          <th> Ширина </th>
          <th> Высота </th>
          <th> Длина </th>
          <th> Действия </th>
        </tr>
        <c:forEach items="${orders}" var="order">
          <tr>
              <td><c:out value="${order.id}"/></td>
              <td><c:out value="${order.article}"/></td>
              <td><c:out value="${order.cost}"/></td>
              <td><c:out value="${order.width}"/></td>
              <td><c:out value="${order.height}"/></td>
              <td><c:out value="${order.length}"/></td>
              <td>
                <a href="/delete?id=${order.id}">Удалить</a> |
                <a href="/detail?id=${order.id}">Подробнее..</a> |
                <a href="/update?id=${order.id}">Изменить</a>
              </td>
          </tr>
        </c:forEach>
      </table>
  </spring:form>
  <a href="/add">Добавить</a>

  </body>
</html>

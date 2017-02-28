<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hi guys!
  <spring:form action="" modelAttribute="" method="post">
    <c:forEach items="${orders}" var="order">
      <c:out value="${order.id}"/>|
      <c:out value="${order.article}"/>|
      <c:out value="${order.cost}"/>|
      <c:out value="${order.width}"/>|
      <c:out value="${order.height}"/>|
      <c:out value="${order.length}"/>
    </c:forEach>
  </spring:form>


  </body>
</html>

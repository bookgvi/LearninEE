<%--
  Created by IntelliJ IDEA.
  User: book
  Date: 21.09.2020
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cookies example app</title>
  </head>
  <body>
    <form method="post" action="${pageContext.request.contextPath}/save-data">
      <label>
        <input type="radio" name="data-type" value="type_1">
        type_1<br>
      </label>
      <label>
        <input type="radio" name="data-type" value="type_2">
        type_2<br>
      </label>
      <br><button type="submit">Get data</button>
    </form>
  </body>
</html>

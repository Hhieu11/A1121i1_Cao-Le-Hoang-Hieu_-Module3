<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/21/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  <h2>Currency Converter</h2>--%>
<%--  <form action="converter" method="post">--%>
<%--    <label>Rate: </label><br/>--%>
<%--    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>--%>
<%--    <label>USD: </label><br/>--%>
<%--    <input type="text" name="usd" placeholder="USD" value="0"/><br/>--%>
<%--    <input type = "submit" id = "submit" value = "Converter"/>--%>
<%--  </form>--%>
<%--  <h1>Rate: ${rate}</h1>--%>
<%--  <h1>USD: ${usd}</h1>--%>
<%--  <h1>VND: ${vnd}</h1>--%>

  <form action="/converter" method="post">
    <input type="text" name="something" placeholder="Enter something">
    <input type="submit" value="submit">
  </form>
  <h1> Hello Spring MVC</h1>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/24/2022
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Sandwich Condiments
</h1>

<form action="save" method="get">
    <input type="checkbox" name="sandwich" value="Lettuce"> Lettuce
    <input type="checkbox" name="sandwich" value="Tomato"> Tomato
    <input type="checkbox" name="sandwich" value="Mustard"> Mustard
    <input type="checkbox" name="sandwich" value="Sprouts"> Sprouts <br>
    <input type="submit" value="save">

</form>
<h2>
    Condiments : ${sand}
</h2>
</body>
</html>

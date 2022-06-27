<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/24/2022
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4> Caculator</h4>
<form method="post" action="caculator">

    <input type="text" name="first" placeholder="Nhap so ">
    <input type="text" name="second" placeholder="Nhap so "><br><br>
    <input type="submit" name="ope" value="+">
    <input type="submit" name="ope" value="-">
    <input type="submit" name="ope" value="*">
    <input type="submit" name="ope" value="/">


</form>
<h2> Result : ${result}</h2>
</body>
</html>

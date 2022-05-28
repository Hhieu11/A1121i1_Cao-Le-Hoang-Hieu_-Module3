<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2022
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to customer list</a>
</p>

<form action="/product?action=edit" method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" id="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Gia: </td>
                <td><input type="text" name="gia" id="gia" value="${requestScope["product"].getGia()}"></td>
            </tr>
            <tr>
                <td>Mo Ta: </td>
                <td><input type="text" name="mota" id="mota" value="${requestScope["product"].getMota()}"></td>
            </tr>
            <tr>
                <td>NSX: </td>
                <td><input type="text" name="nhasx" id="nhasx" value="${requestScope["product"].getNhasx()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>

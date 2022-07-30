<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 2/21/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
            border: 1px solid black;
        }
        th, td, tr{
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Gender</th>
        <th>Country</th>
        <th>CCCD</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Trieu Chung</th>
        <th>Phoi Nhiem</th>
    </tr>
    <c:forEach var="person" items="${list}">
        <tr>
            <td><c:out value="${person.name}"></c:out></td>
            <td><c:out value="${person.date}"></c:out></td>
            <td><c:out value="${person.gender}"></c:out></td>
            <td><c:out value="${person.country}"></c:out></td>
            <td><c:out value="${person.cccd}"></c:out></td>
            <td><c:out value="${person.address}"></c:out></td>
            <td><c:out value="${person.phone}"></c:out></td>
            <td><c:out value="${person.email}"></c:out></td>
            <td>
                <c:out value="${person.infection}"></c:out>
                <c:out value="${person.infection1}"></c:out>
            </td>
            <td>
                <c:out value="${person.symptom}"></c:out>
                <c:out value="${person.symptom2}"></c:out>
                <c:out value="${person.symptom3}"></c:out>
                <c:out value="${person.symptom4}"></c:out>
                <c:out value="${person.symptom5}"></c:out>
                <c:out value="${person.symptom6}"></c:out>
                <c:out value="${person.symptom7}"></c:out>
                <c:out value="${person.symptom8}"></c:out>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/home">Ke khai</a>
</body>
</html>
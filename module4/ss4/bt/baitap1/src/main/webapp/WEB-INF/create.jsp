<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="info" modelAttribute="mailbox">
    <table>
        <tr>
            <td> <form:label path="languages">Languages </form:label></td>
            <td><form:select path="languages">
                <form:option value="English">
                </form:option>
                <form:option value="Vietnamese">
                </form:option>
                <form:option value="Japanese">
                </form:option>
                <form:option value="Chinese">
            </form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="size">size </form:label></td>
            <td><form:select path="size">
                <form:option value="5" ></form:option>
                <form:option value="10"></form:option>
                <form:option value="25"></form:option>
                <form:option value="50"></form:option>
                <form:option value="100"></form:option>
            </form:select>
            </td>
            <td>emails per page</td>
        </tr>
        <tr>
            <td><form:label path="spams">spams </form:label></td>
            <td><form:checkbox path="spams"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">signature </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="submit" value="Cancel"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>

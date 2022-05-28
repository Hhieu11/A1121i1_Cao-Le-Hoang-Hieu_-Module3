<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2022
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=create" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" placeholder="nhâp id"></td>
        </tr>
        <tr>
            <td>Tên</td>
            <td><input type="text" name="name" placeholder="nhâp tên"></td>
        </tr>
        <tr>
            <td>Gia</td>
            <td>
                <td><input type="text" name="gia" placeholder="nhap gia"></td>

            </td>
        </tr>
        <tr>
            <td>Mo ta</td>
            <input type="text" name="mota" placeholder="Nhap mo ta"></td>
        </tr>
        <tr>
            <td>Nha San Xuat</td>
            <td><input type="text" name="nhasx" placeholder="nhập NSX"></td>
        </tr>

        <tr>
            <td>
                <button type="submit">Lưu</button>
            </td>
        </tr>
    </table>

</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/20/2022
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

  <body>
  <table class="table">

    <tr>

      <th scope="col">Ten</th>
      <th scope="col">Ngay Sinh</th>
      <th scope="col">Dia chi</th>
      <th scope="col">Hinh Anh</th>

    </tr>

<c:forEach items="${khachhangList}" var="khachhang" varStatus="status">

    <tr>

      <td>${khachhang.name}</td>
      <td>${khachhang.birthday}</td>
      <td>${khachhang.diachi}</td>
      <td><img src="${khachhang.hinhanh}"></td>

    </tr>
</c:forEach>

  </table>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</html>

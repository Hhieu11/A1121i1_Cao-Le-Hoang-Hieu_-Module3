<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2022
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<body>
<form class="d-flex col-4" method="post" action="/product">
    <input class="form-control me-2" name="txtSearch" type="search" placeholder="Search" aria-label="Search">
    <input type="hidden" name="action" value="search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Ten</th>
        <th scope="col">Gia</th>
        <th scope="col">Mo Ta</th>
        <th scope="col">Nha San Xuat</th>
        <th scope="col"></th>
        <th scope="col"></th>

    </tr>
    </thead>

    <tbody>
<c:forEach items="${productList}" var="product">
    <tr>
        <td>${product.id}</td>
        <td>${product.ten}</td>
        <td>${product.gia}</td>
        <td>${product.mota}</td>
        <td>${product.nhasx}</td>

        <td>
            <button  type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                Delete
            </button>
        </td>
        <td><a href="/product?action=edit&id=${product.id}">Edit</a></td>

    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/product?action=create">Thêm mới</a>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa nhân viên!</h5>
            </div>
            <form action="/product?action=delete&id=${product.id}" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="idDel">
                <div class="modal-body">
                    <p>Bạn có thật sự muốn xóa</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</html>

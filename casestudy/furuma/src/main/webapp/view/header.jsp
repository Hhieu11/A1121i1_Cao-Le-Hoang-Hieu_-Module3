<%--
  Created by IntelliJ IDEA.
  User: nhacp
  Date: 3/30/2022
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="header ">
        <div class="header_top">
            <img class="logo_img" src="./image/logo-mona.png">
            <h1 class="resort_name">Furama Resort</h1>
            <h4 class="name"></h4>
        </div>
    </div>
    <nav class=" navbar navbar-expand-lg navbar-light bg-light">
        <!--            Danh sách sản phẩm -->
        <div class="  container-fluid ">
            <div class="collapse navbar-collapse row" id="navbarSupportedContent">
                <ul class="nav_padding navbar-nav col-8 me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/index.jsp">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                           role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Employee
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/showEmployee">Quản lí nhân viên</a>
                            <a class="dropdown-item" href="/showEmployee?action=create">Thêm nhân viên</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                           role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Customer
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                            <a class="dropdown-item" href="/showCustomer?index=1">Quản lí khách hàng</a>
                            <a class="dropdown-item" href="/showCustomer?action=create">Thêm khách hàng</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>
                <form class="d-flex col-4" method="post" action="/showCustomer">
                    <input class="form-control me-2" name="txtSearch" type="search" placeholder="Search" aria-label="Search">
                    <input type="hidden" name="action" value="search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>

    </nav>
</header>

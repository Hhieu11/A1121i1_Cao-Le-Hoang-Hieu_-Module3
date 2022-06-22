<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql " %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="view/head.jsp" />
<body>
<div class="app">
  <jsp:include page="view/header.jsp" />
  <div class="container-fluid" >
    <div id="" class="row ">
      <div class="col-sm-3 body_bg">
        <ul class="nav flex-column">
          <li class="nav-item nav_item">
            <a class="nav-link nav_item active" href="/showEmployee">Nhân viên</a>
          </li>
          <li class="nav-item nav_item">
            <a class="nav-link nav_item" href="/showCustomer">Khách hàng</a>
          </li>
          <li class="nav-item nav_item">
            <a class="nav-link nav_item" href="#">Sản phẩm</a>
          </li>
        </ul>
      </div>
      <div class="col-9 pt-1 ">
      </div>
    </div>
  </div>

  <jsp:include page="view/footer.jsp" />
</div>

</body>
</html>


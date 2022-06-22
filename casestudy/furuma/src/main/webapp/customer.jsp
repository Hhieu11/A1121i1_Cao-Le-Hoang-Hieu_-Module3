<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2022
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql " %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="view/head.jsp" />
<jsp:include page="view/header.jsp" />
<body>

    <p> ${mess}</p>
<%--    <c:if test="${empty listc}" >--%>
<%--        <h2 class="text-danger">--%>
<%--            Không có khách hàng nào!--%>
<%--            <a href="/showCustomer?action=create">Thêm</a>--%>
<%--        </h2>--%>
<%--    </c:if>--%>
<%--<c:if test="${!empty listc}" >--%>
    <h2 class="text-center">Danh sách khách hàng</h2>
    <table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Họ Tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Loại khách</th>
        <th scope="col">Giới tính</th>
        <th scope="col">SDT</th>
        <th scope="col">Email</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listc}" var="c">
    <tr id="customer${c.id}}" >

        <td>${c.name}</td>
        <td>${c.dateOfBirth}</td>
        <c:choose>
            <c:when test="${c.customerType==1}">
                <td>Diamond</td>

            </c:when>
            <c:when test="${c.customerType==2}">
                <td>Platinum</td>

            </c:when>
            <c:when test="${c.customerType==3}">
                <td>Gold</td>

            </c:when>
            <c:when test="${c.customerType==5}">
                <td>Silver</td>

            </c:when>
            <c:when test="${c.customerType==5}">
                <td>Member</td>

            </c:when>
            <c:otherwise>
                <td>Khác</td>
            </c:otherwise>

        </c:choose>
        <c:choose>
            <c:when test="${c.sex == 1}">
                <td>Nam</td>
            </c:when>
            <c:when test="${c.sex == 0}">
                <td>Nữ</td>
            </c:when>
            <c:otherwise>
                <td>Khác</td>
            </c:otherwise>
        </c:choose>

        <td>${c.sdt}</td>
        <td>${c.email}</td>
        <td>${c.address}</td>

    </tr>
    </c:forEach>

    </tbody>
</table>
<%--    </c:if>--%>
<jsp:include page="view/footer.jsp" />



</body>

</html>

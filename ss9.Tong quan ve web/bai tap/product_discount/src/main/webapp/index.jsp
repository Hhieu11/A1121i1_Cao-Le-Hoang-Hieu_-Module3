<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/19/2022
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discount" method="post">
    <input type="text" name="mota" placeholder="mo ta san pham">
    <input type="text" name="gia" placeholder="gia niem yet  ">
    <input type="text" name="tyle" placeholder="ty le chiet khau  ">
    <button type="submit">Display-Discount</button>
  </form>

  <p> gia chiet khau : ${discountamount}</p>
  <p> tong gia : ${total}</p>


  </body>
</html>

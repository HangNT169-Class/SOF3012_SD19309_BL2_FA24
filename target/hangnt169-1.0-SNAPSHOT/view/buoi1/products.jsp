<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 12/11/24
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Product Code</td>
        <td>Product Name</td>
        <td>Price</td>
        <td>Cate Code</td>
        <td>Cate name</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listProduct}" var="p" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${p.id}</td>
            <td>${p.productCode}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.cate1.categoryCode}</td>
            <td>${p.cate1.categoryName}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>

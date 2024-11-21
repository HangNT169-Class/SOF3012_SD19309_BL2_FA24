<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<h1>xin chao tai khoan: ${sessionScope.uname}</h1>
<a href="/dang-xuat">Dang xuat</a>
<button><a href="/category/view-add">Add Category</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%--  items => 1 mang    --%>
    <c:forEach items="${listCategory}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.id1}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                    <%--  Cach truyen tham so tren duong dan
                                  ?tenbien=giatri
                                  Nen can truyen nhieu hon 1 ts
                                  => tu ts 2 tro di se la dau &
                                  --%>
                <button><a href="/category/delete?a=${cate.id1}">Delete</a></button>
                <button><a href="/category/detail?id=${cate.id1}">Detail</a></button>
                <button><a href="/category/view-update?b=${cate.id1}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

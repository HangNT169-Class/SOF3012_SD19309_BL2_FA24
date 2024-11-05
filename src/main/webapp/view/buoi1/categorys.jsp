<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="">
      Tên: <input name="ten" />
      <button type="submit">Search</button>
    </form>
    <br />
    <button><a href="">Add Cate</a></button>
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
        <c:forEach items="${listCategory}" var="cate">
          <tr>
            <td></td>
            <td>${cate.id1}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>

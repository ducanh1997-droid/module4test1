<%--
  Created by IntelliJ IDEA.
  User: Kho may tinh HN
  Date: 2/17/2023
  Time: 5:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th colspan="2">Action</th>
    </tr>
    <%--    dùng c:forEach để render dữ liệu của list--%>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td><a href="/product/update?id=${p.id}">
                <button>Update</button>
            </a></td>
            <td><a href="/product/delete?id=${p.id}">
                <button>Delete</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<h1>HelloWorld</h1>
<h1>${product}</h1>
<a href="/product/create">Create</a>
</body>
</html>

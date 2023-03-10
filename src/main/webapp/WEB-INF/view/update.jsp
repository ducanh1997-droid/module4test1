<%--
  Created by IntelliJ IDEA.
  User: Kho may tinh HN
  Date: 2/17/2023
  Time: 6:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--form chỉnh sửa thông tin sản phẩm, action tương ứng có kèm id--%>
<h1>Update form</h1>
<form action="/product/update?id=${product.id}" method="post">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <%--            truyền dữ liệu vào input--%>
            <td><input type="text" name="name" id="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td><label for="price">Price:</label></td>
            <td><input type="text" name="price" id="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity:</label></td>
            <td><input type="text" name="quantity" id="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Update</button>
                <a href="/products" style="text-decoration: none">
                    <button>Back to home</button>
                </a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

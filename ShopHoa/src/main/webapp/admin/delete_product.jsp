<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Hoa" %>
<%
    Hoa hoa = (Hoa) request.getAttribute("hoa");
%>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="ProductManagement?action=update&id=<%= hoa.getId() %>" method="post">
        <label for="name">Product Name:</label><br>
        <input type="text" id="name" name="name" value="<%= hoa.getName() %>" required><br><br>
        
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" value="<%= hoa.getPrice() %>" required><br><br>
        
        <label for="quantity">Quantity:</label><br>
        <input type="number" id="quantity" name="quantity" value="<%= hoa.getQuantity() %>" required><br><br>
        
        <input type="submit" value="Update Product">
    </form>
    <a href="ProductManagement?action=list">Back to Product List</a>
</body>
</html>

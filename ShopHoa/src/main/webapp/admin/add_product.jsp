<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="ProductManagement?action=add" method="post">
        <label for="name">Product Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" required><br><br>
        
        <label for="quantity">Quantity:</label><br>
        <input type="number" id="quantity" name="quantity" required><br><br>
        
        <input type="submit" value="Add Product">
    </form>
    <a href="ProductManagement?action=list">Back to Product List</a>
</body>
</html>

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
        <h2>Cập nhật sản phẩm(Hoa)</h2>
        <form method="post">
            <div class="mb-2">
                <label></label>
                <input type="type" name="name" value="" class=""/>
            </div>
            <div class="mb-2">
                <label></label>
                <input type="type" name="name" value="" class=""/>
            </div>
            <div class="mb-2">
                <label></label>
                <input type="type" name="name" value="" class=""/>
            </div>
            <div class="mb-2">
                <label></label>
                <input type="type" name="name" value="" class=""/>
            </div>
            <button type="submit" class="btn btn-primary"><button
        </form>
        <a href="ProductManagement?action=list">Back to Product List</a>
    </body>
</html>

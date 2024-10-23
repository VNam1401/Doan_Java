<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Hoa" %>
<%
    ArrayList<Hoa> dsHoa = (ArrayList<Hoa>) request.getAttribute("dsHoa");
%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <a href="ProductManagement?action=add">Add New Product</a>
    <table border="1">
        <tr>
            <th>Tên Hoa</th>
            <th>Giá</th>
            <th>Hình Ảnh</th>
            <th>Thể Loại</th>
            <th>Actions</th>
        </tr>
        <%
            for (Hoa hoa : dsHoa) {
        %>
        <tr>
            <td><%= hoa.getTenhoa()%></td>
            <td><%= hoa.getGia()%></td>
            <td><%= hoa.getHinh()%></td>
            <td><%= hoa.getMaloai()%></td>
            <td>
                <a href="ProductManagement?action=edit&id=<%= hoa.getTenhoa()%>">Edit</a>
                <a href="delete_product.jsp?id=<%= hoa.getTenhoa()%>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

<%-- 
    Document   : product
    Created on : 25 thg 10, 2024, 00:30:32
    Author     : nguyenvannam
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Hoa"%>
<%@page import="dao.HoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Nhúng nội dung header.jsp và nav.jsp-->
<jsp:include page="shared/header.jsp" />
<jsp:include page="shared/nav.jsp" />
<section class="bg-body-secondary text-center">
    <div class="container">
        <h1 class="jumbotron-heading text-muted">Shop Hoa Tươi</h1>
        <p class="lead text-muted mb-0">CHUYÊN CUNG CẤP ĐIỆN HOA SỐ 1 TẠI VIỆT NAM</p>
    </div>
</section>

<%
    // Lấy tham số mã loại
     String maloai = request.getParameter("maloai");
     //kiểm tra nếu mã loại không null chuyển "maloai" sang số nguyên và lưu vào 'loai' - là 1 nếu không có tham số
     int loai=1;     
     if(maloai!=null)
     {       
        loai = Integer.parseInt(maloai);
     }    
//khởi tạo dao tư HoaDAO lấy ds từ MySQL     
     HoaDAO  dao = new HoaDAO();  
     ArrayList<Hoa> dsHoa = dao.getByCategoryId(loai);
%>

<div class="container" id="main-content">
    <div class="row">
        <div class="col-sm-3">
            <jsp:include page="shared/left.jsp" />             
        </div>
        <div class="col-sm-9">
            
            <div class="row">
                <% 
                   for(Hoa x: dsHoa)
                   {
                %>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card mb-2">
                        <div class="card-header">
                            <%=x.getTenhoa() %>
                        </div>
                        <div class="card-body">
                            <img class="card-img" src="assets/images/products/<%=x.getHinh() %>" alt="Card image cap">                         
                        </div>
                        <div class="card-footer">
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block"><%=x.getGia() %></p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>              
                </div>  
                <%
                    }                  
                %>
               
            </div>                       
        </div>
    </div>
</div>    

</div><!-- /.container -->
<!--nhung noi dung footer.jsp-->
<jsp:include page="shared/footer.jsp" />    

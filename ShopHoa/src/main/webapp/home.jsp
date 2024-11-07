<%-- 
    Document   : home
    Created on : 25 thg 10, 2024, 00:30:32
    Author     : nguyenvannam
--%>
<!--Định dạng số-->
<%@page import="java.text.DecimalFormat"%>
<!--danh sách hoa-->
<%@page import="java.util.ArrayList"%>
<!--Khai báo lớp hoa-->
<%@page import="model.Hoa"%>
<!--truy xuất biểu tượng lớp HoaDAO-->
<%@page import="dao.HoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Nhúng nội dung header.jsp và nav.jsp-->
<jsp:include page="shared/header.jsp" />
<jsp:include page="shared/nav.jsp" />

<!--tạo giao diện--> 
<section class="bg-body-secondary text-center">
    <div class="container">
        <h1 class="jumbotron-heading text-muted">Shop Hoa Tươi</h1>
        <p class="lead text-muted mb-0">CHUYÊN CUNG CẤP ĐIỆN HOA SỐ 1 TẠI VIỆT NAM</p>
    </div>
</section>


<!--tạo bố cục container và chia các cột-->
<div class="container" id="main-content">
    <div class="row">       
        <div class="col-sm-12">
            <div class="row">   
                <%
//                    căn chỉnh số
                    DecimalFormat fmt = new DecimalFormat("#,##0VNĐ");

//                    lấy danh sách HoaDAO từ MySQL
                    HoaDAO hoaDAO = new HoaDAO();   //tạo đối tượng hoaDAO

//                    lấy 10 hoa đầu tiên từ MySQL
                    ArrayList<Hoa> dsHoa = hoaDAO.getTop10();
//                     (vòng lặp for() )duyệt đối tượng Hoa trong danh sách hoa(dsHoa) - Hiển thị thông tin của từng hoa
                    for (Hoa x : dsHoa) {

                %>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card mb-2">
                        <div class="card-header">
                            <%= x.getTenhoa()%>
                        </div>
                        <div class="card-body">
                            <img class="card-img" src="assets/images/products/<%=x.getHinh()%>" alt="Card image cap">                         
                        </div>
                        <div class="card-footer">
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block"> <%=fmt.format(x.getGia())%> </p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>              
                </div>  
                <!--kết thúc vòng lặp for-->
                <%
                    }
                %>

            </div>                       
        </div>
    </div>
</div>    

</div><!-- /.container -->
<!--nhúng nội dung footer.jsp-->
<jsp:include page="shared/footer.jsp" />

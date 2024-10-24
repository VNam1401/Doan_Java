/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDAO;
import dao.LoaiDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Hoa;
import model.Loai;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ProductManagement", urlPatterns = {"/ProductManagement"})
public class ProductManagement extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HoaDAO hoaDAO = new HoaDAO();
        LoaiDAO loai = new LoaiDAO();
        String action = "list";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        switch (action) {
            case "list":
                ArrayList<Hoa> dsHoa = hoaDAO.getAll();//Lấy dữ liệu từ tầng hoa
                ArrayList<Loai> dsloai = loai.getAll();

                request.setAttribute("dsHoa", dsHoa); // truyền dữ liệu từ servlet qua JSP
                request.getRequestDispatcher("admin/list_product.jsp").forward(request, response);
                break;
            case "add":
                if (request.getMethod().equalsIgnoreCase("get")) {
                    request.setAttribute("dsloai", loai.getAll());
                    request.getRequestDispatcher("admin/list_product.jsp").forward(request, response);
                } else if (request.getMethod().equalsIgnoreCase("post")) {
                    String tenhoa = request.getParameter("tenhoa");
                    double gia = Double.parseDouble(request.getParameter("gia"));
                    Part part = request.getPart("hinh");
                    int maloai = Integer.parseInt(request.getParameter("maloai"));
                    String RealPath = request.getServletContext().getRealPath("./assets/images/product");
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                    part.write(RealPath + "/" + filename);
                    Hoa objInsert = new Hoa(0, tenhoa, gia, filename, maloai, new Date(new java.util.Date().getTime()));
                    if (hoaDAO.Insert(objInsert)) {
                        request.setAttribute("success", "Thêm sản phẩm thành công");
                    } else {
                        request.setAttribute("error", "Thêm sản phẩm thất bại");
                    }
                    request.getRequestDispatcher("admin/list_product.jsp").forward(request, response);
                    break;
                }
            case "edit":
                System.out.println("edit");
                //Xử lý trả về giao điện cập nhật
                request.getRequestDispatcher("admin/edit_product.jsp").forward(request, response);
                break;
            case "delete":
                int productID = Integer.parseInt(request.getParameter("id"));
                if (hoaDAO.Delete(productID)) {
                    request.setAttribute("success", "Xóa sản phẩm thành công");
                } else {
                    request.setAttribute("error", "Xóa sản phẩm thất bại");
                }
                response.sendRedirect("ProductManagement?action=list");
                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

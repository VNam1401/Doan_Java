/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class TaikhoanDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public TaiKhoan checkLogin(String Tendangnhap, String Matkhau) {
        TaiKhoan kq = null;
        String sql = "select * from Taikhoan where Tendangnhap=? and Matkhau=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Tendangnhap);
            ps.setString(2, Matkhau);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = new TaiKhoan(rs.getString(1), rs.getString(2));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return kq;
    }

    public static void main(String[] args) {
        TaikhoanDAO tkDAO = new TaikhoanDAO();
        TaiKhoan tk = new TaiKhoan("nam123", "nam123");
        if (tk != null) {
            System.out.println("THanh Cong!");
        } else {
            System.out.println("That Bai??");
        }
    }

}
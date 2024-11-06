/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class TaiKhoan {
    private String Taikhoan;
    private String Matkhau;

    public TaiKhoan(String taikhoan, String matkhau) {
        this.Taikhoan = taikhoan;
        this.Matkhau = matkhau;
    }

    public String getTaikhoan() {
        return Taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.Taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.Matkhau = matkhau;
    }
    
    @Override
    public String toString() {
        return "Taikhoan{" + "ten\u0110N=" + Taikhoan + ", MK=" + Matkhau + '}';
    } 
}

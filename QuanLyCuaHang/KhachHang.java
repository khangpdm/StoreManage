package QuanLyCuaHang;

import java.io.Serializable;

public class KhachHang extends Nguoi {

    public KhachHang(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
    }

    public void xuatThongTin()
    {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│", id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
        System.out.println();
    }

    public String toString()
    {
        return super.toString();
    }



}

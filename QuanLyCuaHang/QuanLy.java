package QuanLyCuaHang;

import java.io.Serializable;

public class QuanLy extends NhanVien implements Serializable {

    public QuanLy(String id, String hoTen, String diaChi, String SDT, String ngaySinh,
                  String gioiTinh, String CMND, int mucLuong) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong);
    }

    @Override
    public void xuatThongTin() {
        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%-16s|",id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
        System.out.println();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}

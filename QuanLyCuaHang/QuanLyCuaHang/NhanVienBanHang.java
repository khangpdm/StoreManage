package QuanLyCuaHang;

import java.io.Serializable;

public class NhanVienBanHang extends NhanVien implements Serializable {
    public NhanVienBanHang(String id, String hoTen, String diaChi, String SDT,
                           String ngaySinh, String gioiTinh, String CMND, int mucLuong)
    {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong);
    }

    @Override
    public void xuatThongTin()
    {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│%-10d│%-16s│%n", 
                          id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong, "Bán hàng");
    }
}

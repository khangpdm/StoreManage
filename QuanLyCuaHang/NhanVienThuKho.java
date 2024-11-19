package QuanLyCuaHang;

import java.io.Serializable;

public class NhanVienThuKho extends NhanVien {

    public NhanVienThuKho(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND, int mucLuong) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong);
    }

    @Override
    public void xuatThongTin()
    {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│%-10d│%-16s│%n", 
                          id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong, "Thủ kho");
    }
}

package QuanLyCuaHang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KhachHang extends Nguoi implements TinhNang<KhachHang> {

    private static List<KhachHang> danhSachKhachHang = new ArrayList<>();

    public KhachHang(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
    }

    @Override
    public void xuatThongTin()
    { 
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│", id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
        System.out.println();
    }

    @Override
    public void them(KhachHang item) {
        danhSachKhachHang.add(item);
        System.out.println("Khách hàng đã được thêm thành công!");
    }

    @Override
    public void sua(KhachHang item) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getId().equals(item.getId())) {
                kh.setHoTen(item.getHoTen());
                kh.setDiaChi(item.getDiaChi());
                kh.setSDT(item.getSDT());
                kh.setNgaySinh(item.getNgaySinh());
                kh.setGioiTinh(item.getGioiTinh());
                kh.setCMND(item.getCMND());
                System.out.println("Khách hàng đã được cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với ID: " + item.getId());
    }

    @Override
    public void xoa(String id) {
        danhSachKhachHang.removeIf(kh -> kh.getId().equals(id));
        System.out.println("Khách hàng đã được xóa thành công!");
    }

    public static List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }



}

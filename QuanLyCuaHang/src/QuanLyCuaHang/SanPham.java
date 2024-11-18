package QuanLyCuaHang;

import java.util.List;
import java.util.Scanner;

public abstract class SanPham implements TinhNang<SanPham>{
    protected String maSanPham; // Mã sản phẩm
    protected String tenSanPham; // Tên sản phẩm
    protected String size; // Kích thước
    protected String mauSac; // Màu sắc
    protected int gia; // Giá bán
    protected String chatLieu; // Chất liệu
    protected String maNhaCungCap; // Mã nhà cung cấp
    protected int soLuong; // Số lượng

    public SanPham() {
        maSanPham = null;
        tenSanPham = null;
        size = null;
        mauSac = null;
        gia = 0;
        chatLieu = null;
        maNhaCungCap = null;
        soLuong = 0;
    }

    public SanPham(String maSanPham, String tenSanPham, String size, String mauSac, int gia, String chatLieu, String maNhaCungCap, int soLuong) {
        setMaSanPham(maSanPham);
        setTenSanPham(tenSanPham);
        setSize(size);
        setMauSac(mauSac);
        setGia(gia);
        setChatLieu(chatLieu);
        setMaNhaCungCap(maNhaCungCap);
        setSoLuong(soLuong);
    }

   /* public boolean ban(int soLuongBan) {
        if (soLuongBan > soLuong) return false;
        soLuong -= soLuongBan; // Giảm số lượng
        return true;
    }*/

    // Getter và Setter
    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getMauSac() { return mauSac; }
    public void setMauSac(String mauSac) { this.mauSac = mauSac; }

    public int getGia() { return gia; }
    public void setGia(int gia) { this.gia = gia; }

    public String getChatLieu() { return chatLieu; }
    public void setChatLieu(String chatLieu) { this.chatLieu = chatLieu; }

    public String getMaNhaCungCap() { return maNhaCungCap; }
    public void setMaNhaCungCap(String maNhaCungCap) { this.maNhaCungCap = maNhaCungCap; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public void nhap(String maSanPham, String maNhaCungCap) {
        this.maSanPham = maSanPham;
        this.tenSanPham = Lib.takeStringInput("Nhập tên sản phẩm: ");
        this.size = Lib.takeStringInput("Nhập kích thước: ");
        this.mauSac = Lib.takeStringInput("Nhập màu sắc: ");
        this.gia = Lib.takeIntegerInput("Nhập giá sản phẩm: ");
        this.chatLieu = Lib.takeStringInput("Nhập chất liệu: ");
        this.maNhaCungCap = maNhaCungCap;
        this.soLuong = Lib.takeIntegerInput("Nhập số lượng có trong kho: ");
    }

    @Override
    public void xuatThongTin() {
        System.out.format("│%-15s│%-18s│%-10s│%-10s│%-10s│%-15s│%-15s│%-10s│%n",
                maSanPham, tenSanPham, size, mauSac, gia, chatLieu, maNhaCungCap, soLuong);
    }

    @Override
    public void sua(String maSanPham) {
        if (this.maSanPham.equals(maSanPham)) {
            this.tenSanPham = Lib.takeStringInput("Nhập tên sản phẩm mới: ");
            this.size = Lib.takeStringInput("Nhập kích thước mới: ");
            this.mauSac = Lib.takeStringInput("Nhập màu sắc mới: ");
            this.gia = Lib.takeIntegerInput("Nhập giá sản phẩm mới: ");
            this.chatLieu = Lib.takeStringInput("Nhập chất liệu mới: ");
            this.soLuong = Lib.takeIntegerInput("Nhập số lượng mới: ");
            Lib.printMessage("Thông tin sản phẩm đã được cập nhật!");
        } else {
            Lib.printMessage("Không tìm thấy sản phẩm với mã: " + maSanPham);
        }
    }

    public static void them(List<SanPham> danhSach) {
        String maSanPham = Lib.takeStringInput("Nhập mã sản phẩm: ");
        String maNhaCungCap = Lib.takeStringInput("Nhập mã nhà cung cấp: ");
        
        SanPham sanPhamMoi = new SanPham(maSanPham, 
                                          Lib.takeStringInput("Nhập tên sản phẩm: "), 
                                          Lib.takeStringInput("Nhập kích thước: "), 
                                          Lib.takeStringInput("Nhập màu sắc: "), 
                                          Lib.takeIntegerInput("Nhập giá: "), 
                                          Lib.takeStringInput("Nhập chất liệu: "), 
                                          maNhaCungCap, 
                                          Lib.takeIntegerInput("Nhập số lượng: "));
        
        danhSach.add(sanPhamMoi);
        Lib.printMessage("Sản phẩm đã được thêm thành công!");
    }

    public static boolean xoa(List<SanPham> danhSach, String maSanPham) {
        SanPham sanPham = timKiem(danhSach, maSanPham);
        if (sanPham != null) {
            danhSach.remove(sanPham);
            Lib.printMessage("Sản phẩm đã được xóa thành công!");
            return true;
        } else {
            Lib.printMessage("Không tìm thấy sản phẩm với mã: " + maSanPham);
            return false;
        }
    }


    // Phương thức tìm kiếm
    public static SanPham timKiem(List<SanPham> danhSach, String maSanPham) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getMaSanPham().equals(maSanPham)) {
                return sanPham; // Trả về sản phẩm tìm thấy
            }
        }
        return null; // Không tìm thấy
    }
}
package QuanLyBanQuanAo;

public class Normal extends SanPham {
    private boolean hangSanXuatNoiDia; // Xác định sản phẩm sản xuất trong nước

    public Normal() {
        super();
        hangSanXuatNoiDia = false;
    }

    public Normal(String maSanPham, String tenSanPham, String size, String mauSac, int gia, String chatLieu, String maNhaCungCap, int soLuong, boolean hangSanXuatNoiDia) {
        super(maSanPham, tenSanPham, size, mauSac, gia, chatLieu, maNhaCungCap, soLuong);
        this.hangSanXuatNoiDia = hangSanXuatNoiDia;
    }

    public boolean isHangSanXuatNoiDia() {
        return hangSanXuatNoiDia;
    }

    public void setHangSanXuatNoiDia(boolean hangSanXuatNoiDia) {
        this.hangSanXuatNoiDia = hangSanXuatNoiDia;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.format("│%-20s│%n", hangSanXuatNoiDia ? "Nội địa" : "Nhập khẩu");
    }

    @Override
    public void sua(String maSanPham) {
        super.sua(maSanPham);
        if (this.maSanPham.equals(maSanPham)) {
            this.hangSanXuatNoiDia = Lib.takeBooleanInput("Sản phẩm có phải sản xuất nội địa không? (true/false): ");
        }
    }
}

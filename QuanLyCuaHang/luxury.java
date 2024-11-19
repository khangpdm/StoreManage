package QuanLyBanQuanAo;

public class Luxury extends SanPham {
    private String thuongHieu; // Thương hiệu sản phẩm
    private boolean baoHanhToanQuoc; // Bảo hành toàn quốc

    public Luxury() {
        super();
        thuongHieu = "";
        baoHanhToanQuoc = false;
    }

    public Luxury(String maSanPham, String tenSanPham, String size, String mauSac, int gia, String chatLieu, String maNhaCungCap, int soLuong, String thuongHieu, boolean baoHanhToanQuoc) {
        super(maSanPham, tenSanPham, size, mauSac, gia, chatLieu, maNhaCungCap, soLuong);
        this.thuongHieu = thuongHieu;
        this.baoHanhToanQuoc = baoHanhToanQuoc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public boolean isBaoHanhToanQuoc() {
        return baoHanhToanQuoc;
    }

    public void setBaoHanhToanQuoc(boolean baoHanhToanQuoc) {
        this.baoHanhToanQuoc = baoHanhToanQuoc;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.format("│%-20s│%-15s│%n", thuongHieu, baoHanhToanQuoc ? "Có" : "Không");
    }

    @Override
    public void sua(String maSanPham) {
        super.sua(maSanPham);
        if (this.maSanPham.equals(maSanPham)) {
            this.thuongHieu = Lib.takeStringInput("Nhập thương hiệu mới: ");
            this.baoHanhToanQuoc = Lib.takeBooleanInput("Sản phẩm có bảo hành toàn quốc không? (true/false): ");
        }
    }
}

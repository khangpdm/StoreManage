package QuanLyCuaHang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class NhanVien extends Nguoi implements TinhNang<NhanVien> {

    private static List<NhanVien> danhSachNhanVien = new ArrayList<>();
    protected int mucLuong;
    protected String chucVu;

    public danhSachNhanVien(){
        danhSachNhanVien.add(new NhanVien(123,MinhKhang,123,123,5/8/2005,Nam,123,100,QuanLy));
        danhSachNhanVien.add(new NhanVien(456,PhamDang,456,456,5/8/2005,Nam,456,50,NhanVien));
    }
    public NhanVien(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND, int mucLuong, String chucVu) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND);
        this.mucLuong = mucLuong;
        this.chucVu = chucVu;
    }

    public int getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(int mucLuong) {
        this.mucLuong = mucLuong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public void xuatThongTin() {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│%-9s│%-16s│", id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, chucVu, mucLuong);
        System.out.println();
    }

    @Override
    public void them(NhanVien item) {
        danhSachNhanVien.add(item);
        Lib.printMessage("Nhân viên đã được thêm thành công!");
    }

    @Override
    public void sua(NhanVien item) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getId().equals(item.getId())) {
                nv.setHoTen(item.getHoTen());
                nv.setDiaChi(item.getDiaChi());
                nv.setSDT(item.getSDT());
                nv.setNgaySinh(item.getNgaySinh());
                nv.setGioiTinh(item.getGioiTinh());
                nv.setCMND(item.getCMND());
                nv.setMucLuong(item.getMucLuong());
                nv.setChucVu(item.getChucVu());
                System.out.println("Nhân viên đã được cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với ID: " + item.getId());
    }

    @Override
    public void xoa(String id) {
        boolean removed = danhSachNhanVien.removeIf(nv -> nv.getId().equals(id));
        if (removed) {
            System.out.println("Nhân viên đã được xóa thành công!");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    public static List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + mucLuong + "-" + chucVu;
    }

    @Override
    public NhanVien timKiem(String id) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getId().equals(id)) {
                return nv;
            }
        }
        return null; // Không tìm thấy
    }
    
    public static void setDanhSachNhanVien(List<NhanVien> danhSach) {
        danhSachNhanVien = danhSach;
    }
    
        // Phương thức đọc danh sách nhân viên từ file
        public static void docNhanVienTuFile(String tenFile) {
            try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");
                    if (data.length < 9) continue; // Kiểm tra dữ liệu hợp lệ
    
                    String id = data[0];
                    String hoTen = data[1];
                    String diaChi = data[2];
                    String SDT = data[3];
                    String ngaySinh = data[4];
                    String gioiTinh = data[5];
                    String CMND = data[6];
                    int mucLuong = Integer.parseInt(data[7]);
                    String chucVu = data[8];
    
                    NhanVien nhanVien = new NhanVien(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong, chucVu) {};
                    nhanVien.them(nhanVien);
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đọc file: " + e.getMessage());
            }
        }

    public static void ghiNhanVienVaoFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (NhanVien nv : danhSachNhanVien) {
                bw.write(nv.getId() + "|" + nv.getHoTen() + "|" + nv.getDiaChi() + "|" +
                         nv.getSDT() + "|" + nv.getNgaySinh() + "|" + nv.getGioiTinh() + "|" +
                         nv.getCMND() + "|" + nv.getMucLuong() + "|" + nv.getChucVu());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }


}

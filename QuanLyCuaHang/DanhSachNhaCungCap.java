package QuanLyCuaHang;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class DanhSachNhaCungCap {
    private ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<>();
    private int count = 0;

    // Lấy mã nhà cung cấp tiếp theo
    public String getID() {
        count++;
        String str = String.format("%03d", count); // Đảm bảo mã có 3 chữ số
        return "NCC" + str;
    }

    // Nhập danh sách nhà cung cấp
    public void themncc() {
        System.out.println(Lib.toBlueText("===== Nhập nhà cung cấp mới ====="));
        String tencc = Lib.takeStringInput("Tên nhà cung cấp: ");
        String diachi = Lib.takeStringInput("Địa chỉ: ");
        String sdt = Lib.takeStringInput("Số điện thoại liên lạc: ");
        String email = Lib.takeStringInput("Email: ");
        String macc = getID();

        listNhaCungCap.add(new NhaCungCap(tencc, diachi, sdt, email, macc));

            // Ghi danh sách vào file
        ghiDanhSachNhaCungCap("C:\\D\\DAIHOC\\HDT\\DO_AN\\QuanLyCuaHang\\NhaCungCap.txt"); // Ghi vào file
    }

    public void xuatTieuDe() {

        System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│ \n",
        "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email");

    }

    // Xuất danh sách nhà cung cấp
    public void xuatDS() {
        System.out.println(Lib.toBlueText("===== Danh sách nhà cung cấp ====="));
        xuatTieuDe();
        for (NhaCungCap nhaCungCap : listNhaCungCap) {
            nhaCungCap.xuatThongTin();
        }
    }

    // Sửa thông tin nhà cung cấp
    public void suaNcc() {
        String id = Lib.takeStringInput("Mã nhà cung cấp cần sửa: ");
        NhaCungCap nhaCungCap = timKiemTheoID(id);
        if (nhaCungCap != null) {
            boolean out = false;
            do {
                xuatTieuDe();
                nhaCungCap.xuatThongTin();
                System.out.println(Lib.toBlueText("===== Sửa thông tin nhà cung cấp ====="));
                System.out.println("1. Sửa tên nhà cung cấp");
                System.out.println("2. Sửa địa chỉ");
                System.out.println("3. Sửa số điện thoại");
                System.out.println("4. Sửa email");
                System.out.println("0. Thoát");
                switch (Lib.takeInputChoice(0, 4)) {
                    case 1 -> nhaCungCap.setTen(Lib.takeStringInput("Nhập tên mới: "));
                    case 2 -> nhaCungCap.setDiaChi(Lib.takeStringInput("Nhập địa chỉ mới: "));
                    case 3 -> nhaCungCap.setSdt(Lib.takeStringInput("Nhập điện thoại mới: "));
                    case 4 -> nhaCungCap.setEmail(Lib.takeStringInput("Nhập email mới: "));
                    case 0 -> out = true;
                }
                if (!out) Lib.clearScreen();
            } while (!out);
            ghiDanhSachNhaCungCap("C:\\D\\DAIHOC\\HDT\\DO_AN\\QuanLyCuaHang\\NhaCungCap.txt");
        } else {
            Lib.printError("Không tìm thấy nhà cung cấp với ID: " + id);
        }
    }

    public NhaCungCap timKiemTheoID(String id) {
        for (NhaCungCap nhaCungCap : listNhaCungCap) {
            if (nhaCungCap.getMaNCC().equals(id)) return nhaCungCap;
        }
        return null;
    }

    // Xóa nhà cung cấp
    public void xoaNcc() {
        String id = Lib.takeStringInput("Tên nhà cung cấp cần xóa: ");
        NhaCungCap find = timKiemTheoID(id);

        if (find != null) {
            listNhaCungCap.remove(find);
            Lib.printMessage("Nhà cung cấp đã xóa khỏi danh sách");

            ghiDanhSachNhaCungCap("C:\\D\\DAIHOC\\HDT\\DO_AN\\QuanLyCuaHang\\NhaCungCap.txt");
        } else {
            Lib.printError("Nhà cung cấp không có trong danh sách");
        }
    }

    public void timKiem() {
        String tuKhoa = Lib.takeStringInput("Nhập từ khóa cần tìm: ");
        ArrayList<NhaCungCap> listFilter = new ArrayList<>();
        for (NhaCungCap nhaCungCap : listNhaCungCap) {
            if (nhaCungCap.getMaNCC().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nhaCungCap.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nhaCungCap.getEmail().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nhaCungCap.getTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nhaCungCap.getSdt().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))) {
                listFilter.add(nhaCungCap);
            }
        }

        System.out.println(Lib.toBlueText("Kết quả tìm kiếm theo từ khóa: ") + Lib.toGreenText(tuKhoa));
        if (listFilter.isEmpty()) {
            Lib.printError("Không tìm được từ khóa này trong danh sách");
        } else {
            xuatTieuDe();
            for (NhaCungCap nhaCungCap : listFilter) {
                nhaCungCap.xuatThongTin();
            }
        }
    }

    public void menuNhacc() {
        boolean out = false;
        do {
            xuatDS();
            System.out.println(Lib.toBlueText("===== MENU NHÀ CUNG CẤP ====="));
            System.out.println("1. Thêm nhà cung cấp mới");
            System.out.println("2. Sửa thông tin nhà cung cấp");
            System.out.println("3. Xóa nhà cung cấp");
            System.out.println("4. Tìm kiếm trong bảng");
            System.out.println("0. Thoát menu");
            switch (Lib.takeInputChoice(0, 4)) {
                case 1 -> themncc();
                case 2 -> suaNcc();
                case 3 -> xoaNcc();
                case 4 -> timKiem();
                case 0 -> out = true;
            }
            if (!out) Lib.clearScreen();
        } while (!out);
    }

    public ArrayList<NhaCungCap> getListNhaCungCap() {
        return listNhaCungCap;
    }

    public void setListNhaCungCap(ArrayList<NhaCungCap> listNhaCungCap) {
        this.listNhaCungCap = listNhaCungCap;
    }

        public void docTuFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) { // Đảm bảo đủ thông tin
                    String tencc = parts[0];
                    String diachi = parts[1];
                    String sdt = parts[2];
                    String email = parts[3];
                    String macc = parts[4];

                    listNhaCungCap.add(new NhaCungCap(tencc, diachi, sdt, email, macc));
                }
            }
            System.out.println("Đã đọc thành công danh sách nhà cung cấp từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void ghiDanhSachNhaCungCap(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (NhaCungCap nhaCungCap : listNhaCungCap) {
                bw.write(nhaCungCap.getTen() + ";" +
                         nhaCungCap.getDiaChi() + ";" +
                         nhaCungCap.getSdt() + ";" +
                         nhaCungCap.getEmail() + ";" +
                         nhaCungCap.getMaNCC());
                bw.newLine();
            }
            System.out.println("Đã cập nhật danh sách nhà cung cấp vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
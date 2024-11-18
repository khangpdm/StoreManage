package QuanLyCuaHang;

import java.util.Scanner;
import java.util.ArrayList;

public class MenuQuanLy {
    private Scanner scanner;
    private DanhSachNhaCungCap danhSachNhaCungCap;

    public MenuQuanLy(Scanner scanner) {
        this.scanner = scanner;
        this.danhSachNhaCungCap = new DanhSachNhaCungCap();
    }

    public void display() {
        boolean managing = true;

        while (managing) {
            System.out.println("\n=== QUẢN LÝ NHÂN VIÊN ===");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Xem danh sách nhà cung cấp");
            System.out.println("3. Xem danh sách nhà sản xuất");
            System.out.println("4. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Lib.takeInputChoice(1, 4);

            switch (choice) {
                case 1:
                    menuQuanLy();
                    break;
                case 2:
                    danhSachNhaCungCap.menuNhacc();
                    break;
                case 3:
                    //deleteEmployee();
                    break;
                case 4:
                    managing = false; // Quay lại menu chính
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void addEmployee() {
        System.out.println("Chức năng thêm nhân viên.");
        System.out.print("Nhập ID nhân viên: ");
        String id = scanner.nextLine();

        if (!Lib.isIdUnique(id)) {
            Lib.printError("ID nhân viên đã tồn tại. Vui lòng nhập ID khác.");
            return;
        }
        
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String SDT = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập CMND: ");
        String CMND = scanner.nextLine();
        System.out.print("Nhập mức lương: ");
        int mucLuong = Lib.takeIntegerInput("Mức lương: ");
        System.out.print("Nhập chức vụ: ");
        String chucVu = scanner.nextLine();

        NhanVien nhanVien = new NhanVien(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong, chucVu) {
        };
        nhanVien.them(nhanVien);
        NhanVien.ghiNhanVienVaoFile("NhanVien.txt");
    }

    private void editEmployee() {
        System.out.println("Chức năng sửa thông tin nhân viên.");
        System.out.print("Nhập ID nhân viên cần sửa: ");
        String id = scanner.nextLine();
        
        NhanVien existingEmployee = new NhanVien("", "", "", "", "", "", "", 0, "") {
            @Override
            public void xuatThongTin() {} // Phương thức trừu tượng không cần thiết ở đây
        }.timKiem(id); // Tạo đối tượng để sử dụng timKiem

        if (existingEmployee != null) {
            System.out.print("Nhập họ tên mới (hiện tại: " + existingEmployee.getHoTen() + "): ");
            existingEmployee.setHoTen(scanner.nextLine());
            System.out.print("Nhập địa chỉ mới (hiện tại: " + existingEmployee.getDiaChi() + "): ");
            existingEmployee.setDiaChi(scanner.nextLine());
            System.out.print("Nhập số điện thoại mới (hiện tại: " + existingEmployee.getSDT() + "): ");
            existingEmployee.setSDT(scanner.nextLine());
            System.out.print("Nhập ngày sinh mới (hiện tại: " + existingEmployee.getNgaySinh() + "): ");
            existingEmployee.setNgaySinh(scanner.nextLine());
            System.out.print("Nhập giới tính mới (hiện tại: " + existingEmployee.getGioiTinh() + "): ");
            existingEmployee.setGioiTinh(scanner.nextLine());
            System.out.print("Nhập CMND mới (hiện tại: " + existingEmployee.getCMND() + "): ");
            existingEmployee.setCMND(scanner.nextLine());
            System.out.print("Nhập mức lương mới (hiện tại: " + existingEmployee.getMucLuong() + "): ");
            existingEmployee.setMucLuong(Lib.takeIntegerInput("Mức lương: "));
            System.out.print("Nhập chức vụ mới (hiện tại: " + existingEmployee.getChucVu() + "): ");
            existingEmployee.setChucVu(scanner.nextLine());

            existingEmployee.sua(existingEmployee);
            Lib.printMessage("Thông tin nhân viên đã được cập nhật thành công!");
            NhanVien.ghiNhanVienVaoFile("NhanVien.txt");
        } else {
            Lib.printError("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    private void deleteEmployee() {
        System.out.println("Chức năng xóa nhân viên.");
        System.out.print("Nhập ID nhân viên cần xóa: ");
        String id = scanner.nextLine();
        
        NhanVien existingEmployee = new NhanVien("", "", "", "", "", "", "", 0, "") {
            @Override
            public void xuatThongTin() {} // Phương thức trừu tượng không cần thiết ở đây
        }.timKiem(id); // Tạo đối tượng để sử dụng timKiem

        if (existingEmployee != null) {
            existingEmployee.xoa(id);
            Lib.printMessage("Nhân viên đã được xóa thành công!");
            NhanVien.ghiNhanVienVaoFile("NhanVien.txt");
        } else {
            Lib.printError("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    private void searchEmployee() {
        System.out.println("Chức năng tìm kiếm nhân viên.");
        System.out.print("Nhập ID nhân viên cần tìm: ");
        String id = scanner.nextLine();
        
        NhanVien foundEmployee = new NhanVien("", "", "", "", "", "", "", 0, "") {
            @Override
            public void xuatThongTin() {} // Phương thức trừu tượng không cần thiết ở đây
        }.timKiem(id); // Tạo đối tượng để sử dụng timKiem

        if (foundEmployee != null) {
            foundEmployee.xuatThongTin(); // Hiển thị thông tin nhân viên
        } else {
            Lib.printError("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    private void displayEmployees() {
        System.out.println("Danh sách nhân viên:");
        for (NhanVien nv : NhanVien.getDanhSachNhanVien()) {
            nv.xuatThongTin(); // Hiển thị thông tin từng nhân viên
        }
    }

    public void menuQuanLy(){
        boolean out = false;
        do{
            displayEmployees();
            System.out.println(Lib.toBlueText("===== MENU NHÂN VIÊN ====="));
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Sửa thông tin nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm kiếm trong bảng");
            System.out.println("0. Thoát menu");
            switch (Lib.takeInputChoice(0, 4)) {
                case 1 -> addEmployee();
                case 2 -> editEmployee();
                case 3 -> deleteEmployee();
                case 4 -> searchEmployee();
                case 0 -> out = true;
            }
            if (!out) Lib.clearScreen();
        } while (!out);
        }
    }

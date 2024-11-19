package QuanLyCuaHang;

import java.util.Scanner;
import java.util.ArrayList;

public class MenuQuanLy {
    private Scanner scanner;
    private DanhSachNhaCungCap danhSachNhaCungCap;
    private Shop shop;

    public MenuQuanLy(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.danhSachNhaCungCap = new DanhSachNhaCungCap();
        this.shop = shop;
        danhSachNhaCungCap.docTuFile("C:\\D\\DAIHOC\\HDT\\DO_AN\\QuanLyCuaHang\\NhaCungCap.txt");
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
                    shop.menuDanhSachNhanVien();
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

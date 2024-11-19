package QuanLyCuaHang;

import java.util.Scanner;

public class DisplaySalesMenu {
    private Shop shop;
    private Scanner scanner;

    public DisplaySalesMenu(Shop shop, Scanner scanner) {
        this.shop = shop;
        this.scanner = scanner;
    }

    public void display() {
        boolean salesRunning = true;

        while (salesRunning) {
            System.out.println("\n=== MENU NHÂN VIÊN BÁN HÀNG ===");
            System.out.println("1. Quản lý hóa đơn");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Thống kê các hóa đơn");
            System.out.println("4. Thống kê các mặt hàng đã bán");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Lib.takeInputChoice(0, 4);

            switch (choice) {
                case 1:

                    break;
                case 2:
                    shop.menuDanhSachKhachHang();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    salesRunning = false; // Quay lại menu chính
                    break;
                default:
                    Lib.printError("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
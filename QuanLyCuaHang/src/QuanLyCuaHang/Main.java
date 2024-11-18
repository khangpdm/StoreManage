package QuanLyCuaHang;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== QUẢN LÝ CỬA HÀNG QUẦN ÁO ===");
            System.out.println("1. Hiển thị danh sách sản phẩm ");
            System.out.println("2. Quản lý");
            System.out.println("3. Thủ kho");
            System.out.println("4. Nhân viên bán hàng");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = Lib.takeInputChoice(1, 5);

            switch (choice) {
                case 1:

                    break;
                case 2:
                    MenuQuanLy menuQuanLy = new MenuQuanLy(scanner);
                    menuQuanLy.display(); // Hiển thị menu nhân viên
                    break;
                case 3:

                    break;
                case 4:
                    //displayProducts();
                    break;
                case 5:
                    running = false;
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    Lib.printError("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        scanner.close();
    }
}
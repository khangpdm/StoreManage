package QuanLyCuaHang;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Lib {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    private static Scanner scanner = new Scanner(System.in);

    // Dùng để lặp lại chuỗi str với n lần
    static String repeatStr(String str, int n) {
        return String.join("", Collections.nCopies(n, str));
    }

    // Nhận input float
    public static float takeFloatInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                printError("Bạn chỉ được phép nhập số");
            }
        }
    }

    // Nhận input int với lựa chọn trong khoảng
    public static int takeInputChoice(int min, int max) {
        int attempts = 0;
        while (true) {
            if (attempts == 0)
                System.out.print("Nhập lựa chọn: ");
            else if (attempts < 2)
                System.out.print("Nhập lại lựa chọn: ");
            else
                System.out.print("Hãy nhìn lại lựa chọn rồi nhập -_- : ");
            String choice = scanner.nextLine();
            try {
                int result = Integer.parseInt(choice);
                if (result >= min && result <= max)
                    return result;
                printError("Lựa chọn của bạn không đúng lắm");
            } catch (NumberFormatException e) {
                printError("Bạn chỉ được phép nhập số");
            }
            attempts++;
        }
    }

    public static int takeSoLuongCanTao(String prompt) {
        int num;
        while (true) {
            num = takeIntegerInput(prompt);
            if (num > 5) {
                printMessage("Số lượng của bạn hơi nhiều");
                System.out.println("1. Tiếp tục");
                System.out.println("2. Nhập lại");
                if (takeInputChoice(1, 2) == 1)
                    return num;
            } else {
                return num;
            }
        }
    }

    // Nhận input String
    public static String takeStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Bạn chưa có nhập gì hết");
            } else if (input.length() > 14) {
                printError("Chiều dài chuỗi vượt quá 14");
            } else {
                return input;
            }
        }
    }

    // Nhận input int
    public static int takeIntegerInput(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                validInput = true; // Đầu vào hợp lệ
            } catch (NumberFormatException e) {
                printError("Bạn chỉ được phép nhập số nguyên hợp lệ!");
            }
        }
        return value;
    }

    // Nhận input ngày
    public static String takeDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Bạn chưa có nhập gì hết");
            } else if (input.length() > 14) {
                printError("Chiều dài chuỗi vượt quá 14");
            } else if (!checkDate(input)) {
                printError("Ngày không đúng định dạng");
            } else {
                return input;
            }
        }
    }

    // Nhận input số điện thoại
    public static String takePhoneNumberInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                printError("Bạn chưa có nhập gì hết");
            } else if (!input.matches("\\d+")) {
                printError("Số điện thoại chỉ chấp nhận số");
            } else if (input.length() > 14) {
                printError("Chiều dài chuỗi vượt quá 14");
            } else {
                return input;
            }
        }
    }

    // Load file
    public static Object load(Object obj, String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            printError("Load " + filename + " thất bại => tạo dữ liệu mặc định");
            return null;
        }
        printMessage("Load " + filename + " thành công");
        return obj;
    }

    // Save file
    public static void save(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            printMessage("Save " + filename + " thành công");
        } catch (IOException e) {
            printError("Save " + filename + " thất bại");
        }
    }

    // Trả về ngày tháng năm hiện tại
    public static String getDateNow() {
        LocalDate date = LocalDate.now();
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }

    // Dùng để clear console
    public static void clearScreen() {
        printMessage("Nhập bất kỳ để tiếp tục");
        scanner.nextLine();
        System.out.printf("%5s", repeatStr("\n", 5));
    }

    // Hiển thị tin nhắn với text màu xanh
    public static void printMessage(String message) {
        System.out.printf("%30s " + TEXT_GREEN + " *** %s *** " + TEXT_RESET + " %30s%n", repeatStr(" ", 30), message, repeatStr(" ", 30));
    }

    // Hiển thị lỗi với text màu đỏ
    public static void printError(String message) {
        System.out.printf("%30s " + TEXT_RED + " *** %s *** " + TEXT_RESET + " %30s%n", repeatStr(" ", 30), message, repeatStr(" ", 30));
    }

    public static boolean checkDate(String date) {
        try {
            String[] part = date.split("/");
            int day = Integer.parseInt(part[0]);
            int month = Integer.parseInt(part[1]);
            int year = Integer.parseInt(part[2]);
            if (day <= 0 || day > 31) return false;
            if (month <= 0 || month > 12) return false;
            return year > 0 && year < 10000;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean subStrInStrIgnoreCase(String str, String subStr) {
        return str.toLowerCase(Locale.ROOT).contains(subStr.toLowerCase(Locale.ROOT));
    }

    public static void main(String[] args) {
        // Có thể thêm mã kiểm tra hoặc ví dụ sử dụng tại đây
    }

    public static void docNhanVienTuFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                String id = data[0];
                String hoTen = data[1];
                String diaChi = data[2];
                String SDT = data[3];
                String ngaySinh = data[4];
                String gioiTinh = data[5];
                String CMND = data[6];
                int mucLuong = Integer.parseInt(data[7]);
                String chucVu = data[8];
    
                NhanVien nhanVien = new NhanVien(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, mucLuong, chucVu) {
                    @Override
                    public void xuatThongTin() {
                        // Implement method if needed
                    }
                };
                nhanVien.them(nhanVien);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public static void ghiNhanVienVaoFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (NhanVien nv : NhanVien.getDanhSachNhanVien()) {
                bw.write(nv.getId() + "|" + nv.getHoTen() + "|" + nv.getDiaChi() + "|" +
                         nv.getSDT() + "|" + nv.getNgaySinh() + "|" + nv.getGioiTinh() + "|" +
                         nv.getCMND() + "|" + nv.getMucLuong() + "|" + nv.getChucVu());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static boolean isIdUnique(String id) {
    for (NhanVien nv : NhanVien.getDanhSachNhanVien()) {
        if (nv.getId().equals(id)) {
            return false;
        }
    }
    return true;
    }

    public static String toBlueText(String text) {
        return "\u001B[34m" + text + "\u001B[0m"; // Mã màu xanh
    }
}
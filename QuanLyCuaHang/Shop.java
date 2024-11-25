package QuanLyCuaHang;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    ArrayList<Nguoi> listNguoi;

    public Shop() {
        listNguoi = new ArrayList<>();
        taoNguoiQuanLy();
        Nguoi nvbh = new NhanVienBanHang(
                "nam", "huynh ngoc nam","idk", "1234",
                "08/08/8888", "Nam", "231512", 100000);
        Nguoi nvtk = new NhanVienThuKho(
                "vu", "vu","idk", "4321",
                "08/08/8888", "Nam", "4325456", 100000);
        Nguoi kh = new KhachHang(
                "minh", "ly minh","idk", "34234",
                "08/08/8888", "Nam", "354235");
        Nguoi kh2 = new KhachHang(
                "sinh", "Duc Sinh","idk", "1235",
                "12/3/2288", "Nam", "42343");
        listNguoi.add(nvbh);
        listNguoi.add(nvtk);
        listNguoi.add(kh);
        listNguoi.add(kh2);
    }


    private void taoNguoiQuanLy() {
        if (listNguoi.stream().filter(x -> x instanceof QuanLy).findAny().orElse(null) != null) {
            System.out.println("Cửa hàng chỉ có 1 người quản lý");
            return;
        }
        Nguoi quanLy = new QuanLy(
                "admin", "MinhKhang",
                "idk", "8565", "08/08/8888",
                "Nam", "85659712", 1000000);
        listNguoi.add(quanLy);
    }

    public Nguoi timKiemTheoID(String id)
    {
        return listNguoi.stream().filter(x -> x.id.equals(id)).findAny().orElse(null);
    }

    //dk = "KhachHang" | "NhanVienThuKho" | "NhanVienBanHang" | "NhanVien"
    public Nguoi timKiemTheoID(String id, String dk)
    {
        if(dk.equals("KhachHang"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof KhachHang).findFirst().orElse(null);
        else if(dk.equals("NhanVienThuKho"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof NhanVienThuKho).findFirst().orElse(null);
        else if(dk.equals("NhanVienBanHang"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof NhanVienBanHang).findFirst().orElse(null);
        else
            return listNguoi.stream().filter(x -> x.id.equals(id) && (x instanceof NhanVienBanHang || x instanceof NhanVienThuKho)).findFirst().orElse(null);
    }


    //Tạo người với lựa chọn. Choice = "KhachHang" | "NhanVien"
    public void taoNguoi(String choice) {
        String id;
        while (true) {
            id = Lib.takeStringInput("Nhập id: ");
            if (timKiemTheoID(id) != null) {
                Lib.printError("ID này đã có vui lòng chọn ID khác");
            } else {
                break;
            }
        }

        String hoTen = Lib.takeStringInput("Nhập họ tên: ");
        String diaChi = Lib.takeStringInput("Nhập địa chỉ: ");
        String sdt = Lib.takePhoneNumberInput("Nhập số điện thoại: ");
        String ns = Lib.takeDateInput("Nhập ngày sinh: ");
        String gt = chonGioiTinh();
        String cmnd = Lib.takeStringInput("Nhập CMND: ");

        if (choice.equals("KhachHang")) {
            Nguoi kh = new KhachHang(id, hoTen, diaChi, sdt, ns, gt, cmnd);
            listNguoi.add(kh);
        } else if (choice.equals("NhanVien")) {
            int mucLuong = Lib.takeIntegerInput("Nhập mức lương: ");
            System.out.println("Chọn chức vụ của nhân viên");
            System.out.println("1. Nhân viên thủ kho");
            System.out.println("2. Nhân viên bán hàng");
            switch (Lib.takeInputChoice(1, 2))
            {
                case 1 -> {
                    Nguoi nhanVienThuKho = new NhanVienThuKho(id, hoTen, diaChi, sdt, ns, gt, cmnd, mucLuong);
                    listNguoi.add(nhanVienThuKho);
                }
                case 2 -> {
                    Nguoi nhanVienBanHang = new NhanVienBanHang(id, hoTen, diaChi, sdt, ns, gt, cmnd, mucLuong);
                    listNguoi.add(nhanVienBanHang);
                }
            }

        }
    }

    public void inDanhsachNhanVien() {
        int count = 0;

        xuatTieuDeNhanVien();
        for (Nguoi nguoi : listNguoi) {
            if (nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Lib.printError("Không có nhân viên nào");
    }

    public void inDanhsachNhanVien(ArrayList<Nguoi> list) {
        int count = 0;
        xuatTieuDeNhanVien();
        for (Nguoi nguoi : list) {
            if (nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Lib.printError("Không có nhân viên nào");
    }

    public void inDanhSachKhangHang() {
        int count = 0;

        xuatTieuDeKhachHang();
        for (Nguoi nguoi : listNguoi) {
            if (nguoi instanceof KhachHang)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Lib.printError("Không có khách hàng nào");
    }

    public void xuatTieuDeKhachHang()
    {
        System.out.printf("┌%-16s┬%-16s┬%-16s┬%-10s┬%-10s┬%-10s┬%-9s┬%-16s┐%n",
                Lib.repeatStr("─", 16), Lib.repeatStr("─", 16), Lib.repeatStr("─", 16),
                Lib.repeatStr("─", 10), Lib.repeatStr("─", 10), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 9), Lib.repeatStr("─", 16));

        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%n",
                "ID khách hàng", "Họ tên", "Địa chỉ", "SDT", "Ngày sinh", "Giới tính", "CMND");

        System.out.printf("├%-16s┼%-16s┼%-16s┼%-10s┼%-10s┼%-10s┼%-9s┼%-16s┤%n",
                Lib.repeatStr("─", 16), Lib.repeatStr("─", 16), Lib.repeatStr("─", 16),
                Lib.repeatStr("─", 10), Lib.repeatStr("─", 10), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 9), Lib.repeatStr("─", 16));
    }

    public void xuatTieuDeNhanVien()
    {
        System.out.printf("┌%-16s┬%-16s┬%-16s┬%-10s┬%-10s┬%-10s┬%-9s┬%-16s┬%-10s┬%-16s┐%n",
                Lib.repeatStr("─", 16), Lib.repeatStr("─", 16), Lib.repeatStr("─", 16),
                Lib.repeatStr("─", 10), Lib.repeatStr("─", 10), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 9), Lib.repeatStr("─", 16), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 16));

        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%-10s|%-16s|%n",
                "ID nhân viên", "Họ tên", "Địa chỉ", "SDT", "Ngày sinh",
                "Giới tính", "CMND", "Mức lương", "Chức vụ");

        System.out.printf("├%-16s┼%-16s┼%-16s┼%-10s┼%-10s┼%-10s┼%-9s┼%-16s┼%-10s┼%-16s┤%n",
                Lib.repeatStr("─", 16), Lib.repeatStr("─", 16), Lib.repeatStr("─", 16),
                Lib.repeatStr("─", 10), Lib.repeatStr("─", 10), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 9), Lib.repeatStr("─", 16), Lib.repeatStr("─", 10),
                Lib.repeatStr("─", 16));
    }

    private void menuSua(Nguoi nguoi)
    {
        int max = 7;
        if(nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            max = 8;
        boolean outChange;
        do {
            outChange = false;
            if(nguoi instanceof KhachHang)
                xuatTieuDeKhachHang();
            else
                xuatTieuDeNhanVien();
            nguoi.xuatThongTin();
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa địa chỉ");
            System.out.println("3. Sửa SDT");
            System.out.println("4. Sửa ngày sinh");
            System.out.println("5. Sửa giới tính");
            System.out.println("6. Sửa CMND");
            System.out.println("7. Sửa password");
            if(nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
                System.out.println("8. Sửa mức lương");
            System.out.println("0. Thoát sửa");

            switch (Lib.takeInputChoice(0, max))
            {
                case 1 -> {nguoi.setHoTen(Lib.takeStringInput("Nhập họ tên mới: "));}
                case 2 -> {nguoi.setDiaChi(Lib.takeStringInput("Nhập địa chỉ mới: "));}
                case 3 -> {nguoi.setSDT(Lib.takePhoneNumberInput("Nhập SDT mới: "));}
                case 4 -> {nguoi.setNgaySinh(Lib.takeDateInput("Nhập ngày sinh mới: "));}
                case 5 -> {nguoi.setGioiTinh(chonGioiTinh());}
                case 6 -> {nguoi.setCMND(Lib.takeStringInput("Nhập CMND mới: "));}
                case 8 -> {((NhanVien)nguoi).setMucLuong(Lib.takeIntegerInput("Nhập mức lương mới: "));}
                case 0 -> {outChange = true;}
            }
            if(!outChange)
                Lib.clearScreen();
        }while (!outChange);
    }


    private String chonGioiTinh() {
        System.out.println("Chọn giới tính:");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = Lib.takeInputChoice(1, 2);
        return (choice == 1) ? "Nam" : "Nữ";
    }


    public void timKiemTrongBang(String s)
    {
        String tuKhoa = Lib.takeStringInput("Nhập từ khóa: ");
        ArrayList<Nguoi> filter = new ArrayList<>();
        if(s.equals("KH"))
        {
            for(Nguoi nguoi : listNguoi)
            {
                if(nguoi instanceof KhachHang)
                {
                    if(
                            nguoi.getHoTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getCMND().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getNgaySinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getGioiTinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getSDT().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                    )
                    {
                        filter.add(nguoi);
                    }
                }
            }

            System.out.println(Lib.toBlueText("Kết quả tìm kiếm theo từ khóa: ")  + Lib.toGreenText(tuKhoa));
            if(!filter.isEmpty())
            {
                xuatTieuDeKhachHang();
                for(Nguoi nguoi : filter)
                {
                    nguoi.xuatThongTin();
                }
            }
            else
                Lib.printError("Không tìm thấy");
        }
        else
        {
            for(Nguoi nguoi : listNguoi)
            {
                if(nguoi instanceof NhanVien)
                {
                    if(
                            nguoi.getHoTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getCMND().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getNgaySinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getGioiTinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getSDT().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                    )
                    {
                        filter.add(nguoi);
                    }
                }
            }
            System.out.println(Lib.toBlueText("Kết quả tìm kiếm theo từ khóa: ")  + Lib.toGreenText(tuKhoa));
            if(!filter.isEmpty())
            {
                xuatTieuDeNhanVien();
                for(Nguoi nguoi : filter)
                {
                    nguoi.xuatThongTin();
                }
            }
            else
                Lib.printError("Không tìm thấy");
        }





    }

    public void menuDanhSachKhachHang()
    {
        boolean out;
        do
        {
            out = false;
            inDanhSachKhangHang();
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Tìm kiếm trong bảng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Sửa");
            System.out.println("0. Thoát");
            switch (Lib.takeInputChoice(0, 4))
            {
                case 1 -> {taoNguoi("KhachHang");}
                case 2 -> timKiemTrongBang("KH");
                case 3 -> {
                    String id = Lib.takeStringInput("Nhập ID khách hàng cần xóa: ");
                    Nguoi obj = timKiemTheoID(id, "KhachHang");
                    if(obj == null)
                        Lib.printError("Không tìm thấy");
                    else{
                        listNguoi.remove(obj);
                        Lib.printMessage("Xóa thành công");
                    }
                }
                case 4 -> {
                    String id = Lib.takeStringInput("Nhập ID khách hàng cần sửa: ");
                    Nguoi obj = timKiemTheoID(id, "KhachHang");
                    if(obj == null)
                        Lib.printError("Không tìm thấy");
                    else{
                        menuSua(obj);
                    }
                }
                case 0 -> {out = true;}
            }
            if(!out)
                Lib.clearScreen();
        }while(!out);
    }

    //dk = "NhanVienBanHang" | "NhanVienThuKho"
    private ArrayList<Nguoi> locDanhSachNhanVien(String dk)
    {
        ArrayList<Nguoi> result;
        if (dk.equals("NhanVienBanHang"))
            result = listNguoi.stream()
                    .filter(x -> x instanceof NhanVienBanHang)
                    .collect(Collectors.toCollection(ArrayList::new));
        else
            result = listNguoi.stream()
                    .filter(x -> x instanceof NhanVienThuKho)
                    .collect(Collectors.toCollection(ArrayList::new));
        if(result.toString().equals("[]"))
            return null;
        return result;
    }

    public void menuDanhSachNhanVien()
    {
        boolean out;
        do
        {
            out = false;
            inDanhsachNhanVien();
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Tìm kiếm trong bảng");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Sửa");
            System.out.println("5. Lọc theo chức vụ");
            System.out.println("0. Thoát");
            switch (Lib.takeInputChoice(0, 5))
            {
                case 1 -> {taoNguoi("NhanVien");}
                case 2 -> timKiemTrongBang("NV");
                case 3 -> {
                    String id = Lib.takeStringInput("Nhập ID nhân viên cần xóa: ");
                    Nguoi obj = timKiemTheoID(id, "NhanVien");
                    if(obj == null)
                        Lib.printError("Không tìm thấy");
                    else{
                        listNguoi.remove(obj);
                        Lib.printMessage("Xóa thành công");
                    }
                }
                case 4 -> {
                    String id = Lib.takeStringInput("Nhập ID nhân viên cần sửa: ");
                    Nguoi obj = timKiemTheoID(id, "NhanVien");
                    if(obj == null)
                        Lib.printError("Không tìm thấy");
                    else{
                        menuSua(obj);
                    }
                }
                case 5 -> {
                    System.out.println("1. Lọc theo nhân viên thủ kho");
                    System.out.println("2. Lọc theo nhân viên bán hàng");
                    switch (Lib.takeInputChoice(1, 2))
                    {
                        case 1 -> {
                            ArrayList<Nguoi> list = locDanhSachNhanVien("NhanVienThuKho");
                            if(list != null)
                                inDanhsachNhanVien(list);
                            else
                                Lib.printError("Không lọc được");
                        }
                        case 2 -> {
                            ArrayList<Nguoi> list = locDanhSachNhanVien("NhanVienBanHang");
                            if(list != null)
                                inDanhsachNhanVien(list);
                            else
                                Lib.printError("Không lọc được");
                        }
                    }
                }
                case 0 -> {out = true;}
            }
            if(!out)
                Lib.clearScreen();
        }while(!out);
    }

}

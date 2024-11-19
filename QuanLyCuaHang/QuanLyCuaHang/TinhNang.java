package QuanLyCuaHang;

public interface TinhNang<T> {
    void them(T item);
    void sua(T item);
    void xoa(String id);
    void xuatThongTin();
    String toString();
    T timKiem(String id);
}
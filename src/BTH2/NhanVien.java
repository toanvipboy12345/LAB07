package BTH2;

/**
 * @author Devmaster
 */
public class NhanVien {
    String name; // Tên của nhân viên
    static int cnt = 0; // Biến đếm số lượng nhân viên

    // Constructor mặc định
    public NhanVien() {
        cnt++;
    }

    // Constructor có tham số
    public NhanVien(String name) {
        this.name = name;
        cnt++;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void display() {
        System.out.println("Tên nhân viên: " + name);
    }

    // Phương thức hiển thị tổng số nhân viên
    public static void displayCount() {
        System.out.println("Tổng số nhân viên: " + cnt);
    }
}
class NhanVienMainClass {

    public static void main(String[] args) {
        // Bước 3: Gán tên cho 3 nhân viên và tăng giá trị biến đếm
        NhanVien[] arrNhanVien = new NhanVien[3];

        // Nhân viên 1
        arrNhanVien[0] = new NhanVien();
        arrNhanVien[0].name = "Ngoc Trinh";

        // Nhân viên 2
        arrNhanVien[1] = new NhanVien();
        arrNhanVien[1].name = "Ba Tung";

        // Nhân viên 3
        arrNhanVien[2] = new NhanVien();
        arrNhanVien[2].name = "Kieu Max";

        // Bước 4: Hiển thị tên và giá trị biến cnt cho từng nhân viên
        for (int i = 0; i < arrNhanVien.length; i++) {
            NhanVien nv = arrNhanVien[i];
            System.out.println(nv.name + " - cnt = " + NhanVien.cnt);
        }

        // Bước 5: Nhận xét

    }
}
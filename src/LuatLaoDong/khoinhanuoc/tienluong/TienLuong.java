package LuatLaoDong.khoinhanuoc.tienluong;

public class TienLuong {
    // Hệ số lương theo cấp bậc
    private static final double TRUNG_CAP = 1.55;
    private static final double CAO_DANG = 1.80;
    private static final double DAI_HOC = 2.34;

    // Mức lương cơ bản
    private static final double LUONG_CO_BAN = 2889000;

    /**
     * Phương thức tính tiền lương
     * @param bacLuong hệ số lương (1.55, 1.80, 2.34)
     * @param thamNien số năm thâm niên công tác
     * @return tiền lương thực nhận
     */
    public static double tinhLuong(double bacLuong, int thamNien) {
        double phuCapThamNien = thamNien * 0.05 * LUONG_CO_BAN;
        return (bacLuong * LUONG_CO_BAN) + phuCapThamNien;
    }

    /**
     * Phương thức tính bảo hiểm công ty phải đóng
     * @param luong tiền lương thực nhận
     * @return số tiền bảo hiểm công ty phải đóng
     */
    public static double tinhBaoHiem(double luong) {
        return luong * 0.16; // 16% lương
    }

    public static void main(String[] args) {
        // Ví dụ sử dụng
        int thamNien = 5; // 5 năm thâm niên
        double bacLuong = DAI_HOC; // Bậc lương Đại học

        // Tính lương và bảo hiểm
        double luong = tinhLuong(bacLuong, thamNien);
        double baoHiem = tinhBaoHiem(luong);

        // In kết quả
        System.out.println("Tiền lương thực nhận: " + luong);
        System.out.println("Tiền bảo hiểm công ty phải đóng: " + baoHiem);
    }
}
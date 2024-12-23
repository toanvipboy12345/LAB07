package BTL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerCity {

    // Class City
    static class City {
        private String cityId;    // Mã thành phố
        private String cityName;  // Tên thành phố
        private String country;   // Tên nước
        private double area;      // Diện tích

        // Constructor không tham số
        public City() {
        }

        // Constructor có tham số
        public City(String cityId, String cityName, String country, double area) {
            this.cityId = cityId;
            this.cityName = cityName;
            this.country = country;
            this.area = area;
        }

        // Các phương thức get/set
        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        // Hàm nhập thông tin
        public void nhap() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập mã thành phố: ");
            cityId = scanner.nextLine();

            System.out.print("Nhập tên thành phố: ");
            cityName = scanner.nextLine();

            System.out.print("Nhập tên nước: ");
            country = scanner.nextLine();

            System.out.print("Nhập diện tích: ");
            area = scanner.nextDouble();
        }

        // Hàm hiển thị thông tin
        public void hienThi() {
            System.out.printf("Mã TP: %s - Tên TP: %s - Tên nước: %s - Diện tích: %.2f km2%n",
                    cityId, cityName, country, area);
        }
    }

    // Hàm main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<City> cities = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập thông tin n thành phố");
            System.out.println("2. Hiển thị thông tin vừa nhập");
            System.out.println("3. Sắp xếp thông tin tăng dần theo tên nước");
            System.out.println("4. Tìm kiếm thông tin theo cityId");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập số lượng thành phố: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin thành phố thứ " + (i + 1) + ":");
                        City city = new City();
                        city.nhap();
                        cities.add(city);
                    }
                }
                case 2 -> {
                    System.out.println("\nThông tin các thành phố:");
                    for (City city : cities) {
                        city.hienThi();
                    }
                }
                case 3 -> {
                    cities.sort(Comparator.comparing(City::getCountry));
                    System.out.println("\nThông tin sau khi sắp xếp theo tên nước:");
                    for (City city : cities) {
                        city.hienThi();
                    }
                }
                case 4 -> {
                    scanner.nextLine(); // Xóa bộ đệm
                    System.out.print("Nhập mã thành phố cần tìm: ");
                    String searchId = scanner.nextLine();
                    boolean found = false;

                    for (City city : cities) {
                        if (city.getCityId().equalsIgnoreCase(searchId)) {
                            System.out.println("\nThông tin thành phố tìm thấy:");
                            city.hienThi();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy thành phố với mã: " + searchId);
                    }
                }
                case 5 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }
}

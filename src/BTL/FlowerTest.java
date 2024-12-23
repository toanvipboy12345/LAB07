package BTL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FlowerTest {

    // Class Flower
    static class Flower {
        private String flowerID;      // Mã hoa
        private String flowerName;    // Tên hoa
        private String color;         // Màu hoa
        private int kindOfFlower;     // Số chủng loại của loài hoa

        // Constructor không tham số
        public Flower() {
        }

        // Constructor có tham số
        public Flower(String flowerID, String flowerName, String color, int kindOfFlower) {
            this.flowerID = flowerID;
            this.flowerName = flowerName;
            this.color = color;
            this.kindOfFlower = kindOfFlower;
        }

        // Các phương thức get/set
        public String getFlowerID() {
            return flowerID;
        }

        public void setFlowerID(String flowerID) {
            this.flowerID = flowerID;
        }

        public String getFlowerName() {
            return flowerName;
        }

        public void setFlowerName(String flowerName) {
            this.flowerName = flowerName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getKindOfFlower() {
            return kindOfFlower;
        }

        public void setKindOfFlower(int kindOfFlower) {
            this.kindOfFlower = kindOfFlower;
        }

        // Hàm nhập thông tin hoa
        public void input() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập mã hoa: ");
            flowerID = scanner.nextLine();

            System.out.print("Nhập tên hoa: ");
            flowerName = scanner.nextLine();

            System.out.print("Nhập màu hoa: ");
            color = scanner.nextLine();

            System.out.print("Nhập số chủng loại của loài hoa: ");
            kindOfFlower = scanner.nextInt();
        }

        // Hàm hiển thị thông tin hoa
        public void display() {
            System.out.printf("Mã hoa: %s - Tên hoa: %s - Màu hoa: %s - Số chủng loại: %d%n",
                    flowerID, flowerName, color, kindOfFlower);
        }
    }

    // Hàm main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Flower> flowers = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("a. Nhập thông tin n loài hoa");
            System.out.println("b. Hiển thị thông tin vừa nhập");
            System.out.println("c. Sắp xếp danh sách tăng dần theo tên hoa");
            System.out.println("d. Tìm kiếm theo flowerID");
            System.out.println("e. Hiển thị tất cả các loài hoa có màu trắng");
            System.out.println("f. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a' -> {
                    System.out.print("Nhập số lượng loài hoa: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin loài hoa thứ " + (i + 1) + ":");
                        Flower flower = new Flower();
                        flower.input();
                        flowers.add(flower);
                    }
                }
                case 'b' -> {
                    System.out.println("\nThông tin các loài hoa:");
                    for (Flower flower : flowers) {
                        flower.display();
                    }
                }
                case 'c' -> {
                    flowers.sort(Comparator.comparing(Flower::getFlowerName));
                    System.out.println("\nDanh sách sau khi sắp xếp tăng dần theo tên hoa:");
                    for (Flower flower : flowers) {
                        flower.display();
                    }
                }
                case 'd' -> {
                    scanner.nextLine(); // Xóa bộ đệm
                    System.out.print("Nhập mã hoa cần tìm: ");
                    String searchID = scanner.nextLine();
                    boolean found = false;

                    for (Flower flower : flowers) {
                        if (flower.getFlowerID().equalsIgnoreCase(searchID)) {
                            System.out.println("\nThông tin hoa tìm thấy:");
                            flower.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy hoa với mã: " + searchID);
                    }
                }
                case 'e' -> {
                    System.out.println("\nDanh sách các loài hoa có màu trắng:");
                    for (Flower flower : flowers) {
                        if ("Trắng".equalsIgnoreCase(flower.getColor())) {
                            flower.display();
                        }
                    }
                }
                case 'f' -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 'f');
    }
}

public class MainClass {

    /**
     * Displays the value of PI
     *
     * @param pi a float variable storing the value of PI
     */
    public void display(float pi) {
        // In giá trị được truyền vào
        System.out.println("The value of PI is: " + pi);
    }

    public static void main(String[] args) {
        // Khởi tạo đối tượng MainClass với từ khóa final
        final MainClass objFinal = new MainClass();

        // Gọi phương thức display() thông qua đối tượng objFinal
        objFinal.display(22.7F);

        // Thử gán lại giá trị hoặc thay đổi objFinal (nếu cần)

    }
}

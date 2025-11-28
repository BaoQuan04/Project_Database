package main;

import com.steam.model.User;
import com.steam.repository.UserRepository;
import com.steam.repository.impl.UserRepositoryImpl;
import com.steam.service.UserService;
import com.steam.service.impl.UserServiceImpl;
import com.steam.util.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    // Khởi tạo các tầng (layers) để sử dụng
    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final UserService userService = new UserServiceImpl(userRepository);

    public static void main(String[] args) {
        // 1. Kiểm tra kết nối DB
        Connection con = DBConnection.getConnection();
        if(con == null){
            System.err.println("--- LỖI KẾT NỐI DB! ỨNG DỤNG KHÔNG THỂ CHẠY CÁC CHỨC NĂNG DB. ---");
            // Không nên chạy tiếp các chức năng nếu không có kết nối DB
            return;
        }
        System.out.println("--- KẾT NỐI DB THÀNH CÔNG ---");

        // 2. Chạy giao diện console
        runConsoleApp();

        // Đóng kết nối nếu cần (tuy nhiên thường DBConnection sẽ quản lý Pool)
        // try { if (con != null) con.close(); } catch (Exception e) {}
    }

    /**
     * Chạy giao diện console để tương tác với người dùng.
     */
    private static void runConsoleApp() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("\n--- CHỨC NĂNG QUẢN LÝ USER ---");

        while (choice != 0) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Tìm kiếm User theo ID");
            System.out.println("2. Tìm kiếm User theo Name");
            System.out.println("3. Nạp tiền vào Ví (Top-Up)");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }

            switch (choice) {
                case 1:
                    searchByUserId(scanner);
                    break;
                case 2:
                    searchByUserName(scanner);
                    break;
                case 3:
                    topUpWallet(scanner);
                    break;
                case 0:
                    System.out.println("Đã thoát ứng dụng. Tạm biệt!");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        }
        scanner.close();
    }

    // --- CÁC HÀM XỬ LÝ CHỨC NĂNG ---

    private static void searchByUserId(Scanner scanner) {
        System.out.print("Nhập User ID cần tìm (số nguyên): ");
        try {
            int userId = Integer.parseInt(scanner.nextLine());

            // Gọi hàm từ tầng Service để lấy chi tiết User
            User user = userService.getUserDetails(userId);

            if (user != null) {
                printUserDetails(user);
            } else {
                System.out.println("\n🚫 KHÔNG TÌM THẤY User với ID: " + userId);
            }
        } catch (NumberFormatException e) {
            System.err.println("Lỗi nhập liệu: ID phải là số nguyên.");
        }
    }

    private static void searchByUserName(Scanner scanner) {
        System.out.print("Nhập User Name cần tìm: ");
        String userName = scanner.nextLine();

        // CẦN THIẾT: Bạn phải thêm hàm findUserByUsername(String) vào UserService
        // Tạm thời gọi userRepository trực tiếp để kiểm tra chức năng DB
        User user = userRepository.findByUserName(userName);

        if (user != null) {
            printUserDetails(user);
        } else {
            System.out.println("\n🚫 KHÔNG TÌM THẤY User với User Name: " + userName);
        }
    }

    private static void topUpWallet(Scanner scanner) {
        System.out.print("Nhập User ID cần nạp tiền: ");
        try {
            int userId = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số tiền cần nạp: ");
            double amount = Double.parseDouble(scanner.nextLine());

            boolean success = userService.topUpWallet(userId, amount);

            if (success) {
                double newBalance = userService.getWalletBalance(userId);
                System.out.printf("✅ Nạp tiền thành công! Số dư mới của User %d là: %.2f\n", userId, newBalance);
            } else {
                System.err.println("❌ Nạp tiền thất bại. Kiểm tra ID User và số tiền nạp.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Lỗi nhập liệu: ID hoặc số tiền phải là số.");
        }
    }

    private static void printUserDetails(User user) {
        System.out.println("\n--- Thông tin User đã tìm thấy ---");
        System.out.println("ID: " + user.getUserId());
        System.out.println("Tên: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.printf("Số dư Ví: %.2f\n", user.getWalletBalance());
        System.out.println("------------------------------------");
    }
}
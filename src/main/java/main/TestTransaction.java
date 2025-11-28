package main;

import com.steam.model.Game;
import com.steam.model.User;
import com.steam.repository.*;
import com.steam.repository.impl.*; // Cần đảm bảo tất cả Impl đều có ở đây
import com.steam.service.TransactionService;
import com.steam.service.impl.TransactionServiceImpl; // Sử dụng lớp Service đã hoàn thiện
import com.steam.util.DBConnection;

import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;

public class TestTransaction {

    // --- KHỞI TẠO CÁC REPOSITORIES VÀ SERVICES ---
    // Khởi tạo các đối tượng triển khai thực tế (Impl)
    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final GameRepository gameRepository = new GameRepositoryImpl();
    private static final TransactionRepository transactionRepository = new TransactionRepositoryImpl();
    private static final ContainRepository containRepository = new ContainRepositoryImpl(); // Repository cho bảng CONTAIN

    // Khởi tạo Service với các dependencies
    private static final TransactionService transactionService = new TransactionServiceImpl(
            userRepository,
            gameRepository,
            transactionRepository,
            containRepository
    );

    public static void main(String[] args) {
        // 1. Kiểm tra kết nối DB
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.err.println("--- LỖI KẾT NỐI DB! KHÔNG THỂ KIỂM TRA CHỨC NĂNG. ---");
            return;
        }
        System.out.println("--- KẾT NỐI DB THÀNH CÔNG ---");

        // 2. Chạy kịch bản kiểm thử
        runTransactionTestScenario();

        try {
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Mô phỏng kịch bản mua game.
     */
    private static void runTransactionTestScenario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- THIẾT LẬP KIỂM THỬ MUA GAME ---");

        System.out.print("Nhập ID User kiểm thử (Phải tồn tại trong DB): ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập ID Game kiểm thử (Phải tồn tại trong DB): ");
        int gameId = Integer.parseInt(scanner.nextLine());

        System.out.println("\n--- BƯỚC 1: KIỂM TRA DỮ LIỆU HIỆN TẠI ---");

        User userBefore = userRepository.findById(userId);
        Game game = gameRepository.findById(gameId);

        if (userBefore == null || game == null) {
            System.err.println("Lỗi: User hoặc Game không tìm thấy trong DB. Vui lòng kiểm tra ID.");
            return;
        }

        System.out.printf("User: %s | Số dư ban đầu: %.2f\n", userBefore.getUserName(), userBefore.getWalletBalance());
        System.out.printf("Game: %s | Giá: %.2f\n", game.getGameName(), game.getPrice());
        System.out.println("----------------------------------------");

        // 3. Thực hiện giao dịch
        System.out.println("\n--- BƯỚC 2: THỰC HIỆN GIAO DỊCH buyGame() ---");
        boolean isSuccess = transactionService.buyGame(userId, gameId);

        // 4. Kiểm tra kết quả
        System.out.println("\n--- BƯỚC 3: KIỂM TRA KẾT QUẢ CUỐI CÙNG ---");

        if (isSuccess) {
            User updatedUser = userRepository.findById(userId);

            System.out.println("✅ GIAO DỊCH MUA GAME THÀNH CÔNG!");
            System.out.printf("   Số dư sau khi mua: %.2f\n", updatedUser.getWalletBalance());
            System.out.println("   Kiểm tra bảng CONTAIN và TRANSACTION trong DB để xác nhận.");
        } else {
            System.err.println("❌ GIAO DỊCH THẤT BẠI! (Số dư không đủ, Game đã sở hữu, hoặc lỗi DB).");
        }
    }
}
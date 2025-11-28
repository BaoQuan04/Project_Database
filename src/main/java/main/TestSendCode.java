package main; // Thay bằng package main; nếu bạn dùng tên đó

import com.steam.util.RandomCode;
import com.steam.util.SendVerification;
import com.steam.util.DBConnection; // Dùng để kiểm tra kết nối DB

import java.sql.Connection;
import java.util.Scanner;

public class TestSendCode {

    public static void main(String[] args) {
        // 1. Kiểm tra kết nối Database (Bước quan trọng)
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.err.println("--- LỖI KẾT NỐI DB! Vui lòng kiểm tra MySQL Server và cấu hình DBConnection. ---");
        } else {
            System.out.println("--- KẾT NỐI DB THÀNH CÔNG ---");
        }

        // 2. Chạy chức năng kiểm tra gửi Email
        testSendVerificationCode();
    }

    /**
     * Chức năng kiểm tra tạo mã ngẫu nhiên và gửi email.
     */
    private static void testSendVerificationCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- CHỨC NĂNG KIỂM TRA GỬI EMAIL XÁC THỰC ---");

        // 1. Nhập email người nhận
        System.out.print("Vui lòng nhập email nhận mã xác thực (Ví dụ: your_personal_email@gmail.com): ");
        String recipientEmail = scanner.nextLine();

        // 2. Tạo mã xác thực 6 chữ số
        String verificationCode = RandomCode.generateConfirmCode();
        System.out.println("Đã tạo mã xác thực: " + verificationCode);

        // 3. Gọi dịch vụ gửi email
        SendVerification mailSender = new SendVerification();

        System.out.println("Đang tiến hành gửi email đến " + recipientEmail + "...");

        // Gửi email
        boolean isSent = mailSender.sendVerificationCode(recipientEmail, verificationCode);

        if (isSent) {
            System.out.println("\n✅ **GỬI EMAIL THÀNH CÔNG!** Vui lòng kiểm tra hộp thư đến.");
        } else {
            System.err.println("\n❌ **GỬI EMAIL THẤT BẠI!** Kiểm tra lỗi chi tiết bên trên.");
            System.err.println("Lưu ý: Kiểm tra lại Mật khẩu Ứng dụng và email người gửi trong SendVerification.java");
        }

        scanner.close();
    }
}
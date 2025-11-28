package com.steam.repository;

import com.steam.model.Developer;
import java.util.List;

public interface DeveloperRepository {
    // Thêm mới hoặc cập nhật Developer
    Developer saveDeveloper(Developer developer);

    // Tìm Developer bằng ID
    Developer findById(int devId);

    // Tìm Developer bằng tên (thường dùng để kiểm tra trùng lặp)
    List<Developer> findByName(String devName);

    // Xóa Developer bằng ID
    boolean deleteById(int devId);

    Developer getDeveloperViaGame(int gameID);
}

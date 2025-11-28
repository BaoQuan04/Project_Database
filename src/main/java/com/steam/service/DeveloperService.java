package com.steam.service;

import com.steam.model.Developer;

public interface DeveloperService {
    // Thêm mới một Developer (thường bao gồm logic kiểm tra trùng lặp tên/email)
    Developer createDeveloper(Developer developer);

    // Cập nhật thông tin Developer đã tồn tại
    Developer updateDeveloper(Developer developer);

    // Lấy thông tin chi tiết của một Developer
    Developer getDeveloperDetails(int devId);

    // Xóa một Developer
    boolean deleteDeveloper(int devId);
}

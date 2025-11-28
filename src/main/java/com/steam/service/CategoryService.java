package com.steam.service;
import com.steam.model.Category;

public interface CategoryService {
    // Thêm mới một Category (thường bao gồm logic kiểm tra trùng lặp tên, v.v.)
    Category createCategory(Category category);

    // Cập nhật thông tin Category đã tồn tại
    Category updateCategory(Category category);

    // Lấy thông tin chi tiết của một Category
    Category getCategoryDetails(int categoryId);

    // Xóa một Category
    boolean deleteCategory(int categoryId);
}

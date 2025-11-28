package com.steam.repository;

import com.steam.model.Category;
import java.util.List;

public interface CategoryRepository {
    // Thêm mới hoặc cập nhật Category
    Category saveCategory(Category category);

    // Tìm Category bằng ID
    Category findById(int categoryId);

    // Xóa Category bằng ID
    boolean deleteById(int categoryId);

    Category findByName(String categoryName);
    
    List<Category> findByNameContaining(String inputString);
}

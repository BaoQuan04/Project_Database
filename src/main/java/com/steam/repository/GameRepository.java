package com.steam.repository;

import com.steam.model.Game;
import java.util.List;

public interface GameRepository {

    Game save(Game game);          // Thêm mới (INSERT) hoặc Cập nhật (UPDATE)
    Game findById(int gameId);     // Tìm kiếm theo ID
    boolean deleteById(int gameId);

    // Tìm kiếm tất cả game theo tên chính xác
    List<Game> findByName(String name);

    // Tìm kiếm tất cả game có tên chứa một chuỗi (không phân biệt chữ hoa/thường)
    List<Game> findByNameContainingIgnoreCase(String keyword);

    // Tìm kiếm tất cả game có giá lớn hơn một mức nào đó
    List<Game> findByPriceGreaterThan(double price);

    // Tìm game theo nhà phát triển VÀ thể loại
    List<Game> findByDeveloper(int devID);

    List<Game> findByCategory(String category);
    
    String findGenre(int gameId);
}

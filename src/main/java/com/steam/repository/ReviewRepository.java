package com.steam.repository;


import com.steam.model.*;

import java.util.List;


public interface ReviewRepository {

    Review save(Review review);

    boolean deleteByGameIdAndUserId( int gameId, int userId);

    Review findByGameIdAndUserId(int gameId, int userId);

    List<ReviewWithUser> findByGameId(int gameId);

    int countByGameId(int gameId);
}

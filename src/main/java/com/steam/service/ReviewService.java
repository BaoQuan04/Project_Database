package com.steam.service;

import com.steam.model.Review;
import com.steam.model.ReviewWithUser;
import java.util.ArrayList;
import java.util.List;

public interface ReviewService {

    Review save(Review review);
    boolean deleteByGameIdAndUserId(int gameId, int userId);
    Review findByGameIdAndUserId(int gameId, int userId);
    List<ReviewWithUser> findByGameId(int gameId);
    int countByGameId(int gameId);

}

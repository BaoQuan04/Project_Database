package com.steam.service.impl;

import com.steam.model.Review;
import com.steam.model.ReviewWithUser;
import com.steam.repository.ReviewRepository;
import com.steam.service.ReviewService;
import com.steam.repository.impl.ReviewRepositoryImpl;
import java.util.Collections;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    final ReviewRepositoryImpl reviewRepository = new ReviewRepositoryImpl();

    @Override
    public Review save(Review review) {
        if(review.getComment() == null | review.getComment().isEmpty()){
            return null;
        }
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteByGameIdAndUserId(int gameId, int userId) {
       return reviewRepository.deleteByGameIdAndUserId(gameId, userId);
    }

    @Override
    public Review findByGameIdAndUserId(int gameId, int userId) {
        return reviewRepository.findByGameIdAndUserId(gameId, userId);
    }

    @Override
    public List<ReviewWithUser> findByGameId(int gameId) {
        return  reviewRepository.findByGameId(gameId);
    }

    @Override
    public int countByGameId(int gameId) {
        return reviewRepository.countByGameId(gameId);
    }
}

package com.steam.model;

public class Review {
    private int gameId, userId;
    private String comment;
    private String rating;

    public Review() {
    }

    public Review(int gameId, int userId, String comment, String rating) {
        this.gameId = gameId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

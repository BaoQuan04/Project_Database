package com.steam.repository;

public interface Has_GenreRepository {
    boolean isGameHasGenre(int gameId, int categoryId);
    boolean addGameToHasGenre(int gameId, int categoryId);
}

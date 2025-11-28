package com.steam.service;

import com.steam.model.Game;
import java.util.List;

public interface GameService {

    boolean removeGame(int gameId);

    Game getGameDetails(int gameId);

    List<Game> getAllGames();

    List<Game> searchGamesByKeyword(String keyword);

    List<Game> filterGamesByMinPrice(double minPrice);

    List<Game> findGamesByDeveloperAndCategory(String developer, String category);
}
package com.steam.repository;

import com.steam.model.*;
import com.steam.repository.impl.*;
import com.steam.service.impl.*;
import java.util.List;

public interface ContainRepository {

    boolean isGameOwnedByUser(int userId, int gameId);
    List<Game> gamesOwnByUser(int user_id);
    boolean addGameToUser(int userId, int gameId);
    boolean removeGameFromUser(int userId, int gameId);
}

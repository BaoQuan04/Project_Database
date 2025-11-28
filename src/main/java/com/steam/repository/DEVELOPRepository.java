package com.steam.repository;

public interface DEVELOPRepository {
    boolean isGameDevelopByDeveloper(int devId, int gameId);
    boolean addGameToDeveloper(int devId, int gameId);

}

package com.dekwin.service;

import com.dekwin.game.Deck;
import com.dekwin.game.GameCard;
import com.dekwin.game.GameData;

import java.util.List;

/**
 * Created by igor on 13.08.17.
 */
public interface CardService {
    Deck getDeckForUser(long userId, GameData gameData);
}

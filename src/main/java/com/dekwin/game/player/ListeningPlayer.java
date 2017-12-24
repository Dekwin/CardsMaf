package com.dekwin.game.player;

import com.dekwin.game.GameCard;

import java.util.List;

/**
 * Created by igor on 22.08.17.
 */
public interface ListeningPlayer {
     void setActiveCards(List<GameCard> activeCards);
    void defendingPlayerSet(Player player);
    void takeCards();
}

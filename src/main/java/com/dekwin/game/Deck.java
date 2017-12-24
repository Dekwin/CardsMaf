package com.dekwin.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12.08.17.
 */
public class Deck {
    private List<GameCard> cards = new ArrayList<>();

    public List<GameCard> getCards() {
        return cards;
    }

    public void setCards(List<GameCard> cards) {
        this.cards = cards;
    }
}

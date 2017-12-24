package com.dekwin.game.player;

import com.dekwin.connection.Connection;
import com.dekwin.game.Game;
import com.dekwin.game.RoleType;
import com.dekwin.connection.GameConnection;
import com.dekwin.game.Deck;
import com.dekwin.game.GameCard;
import com.dekwin.game.action.Action;

import java.util.List;

/**
 * Created by igor on 12.08.17.
 */
public class Player implements ListeningPlayer {
    private long id;
    private int health;
    private String avatarUrl;
    private String nickname;
    private RoleType type;
    private  List<GameCard> activeCards;
    Deck deck;
    GameConnection gameConnection;
    Game currentGame;

    public long getId() {
        return id;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
        gameConnection.deckSet(deck);
    }

    public void defendingPlayerSet(Player player){

    }

    @Override
    public void takeCards() {

    }

    public List<GameCard> getActiveCards() {
        return activeCards;
    }

    public void setActiveCards(List<GameCard> activeCards) {
        this.activeCards = activeCards;
    }

    public Player(int health, RoleType type, GameConnection gameConnection, Game currentGame) {
        this.health = health;
        this.type = type;
        this.gameConnection = gameConnection;
        this.currentGame = currentGame;
    }

    public Player(int health, RoleType type, Connection connection, Game currentGame) {
        this.health = health;
        this.type = type;
        this.gameConnection = new GameConnection(connection, this);
        this.currentGame = currentGame;



    }

    public void perform(Action action){

    }


}

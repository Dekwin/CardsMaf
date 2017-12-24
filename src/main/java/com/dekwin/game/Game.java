package com.dekwin.game;

import com.dekwin.User;
import com.dekwin.game.action.TakeCardsAction;
import com.dekwin.game.action.visitor.ActionPerformer;
import com.dekwin.game.action.visitor.ActionVisitor;
import com.dekwin.game.player.Player;
import com.dekwin.game.timer.GameTimer;
import com.dekwin.service.CardService;

import java.util.*;

/**
 * Created by igor on 12.08.17.
 */
public class Game {


    // private Random randomGenerator;


    //@Autowire
    private CardService cardService;
    //

    private LinkedList<Player> players = new LinkedList<>();
    int defendingPlayerIndex = -1;
    private List<CardCell> cardCells = new ArrayList<>();
    private GameTimer gameTimer = new GameTimer(this);
    //private GameState state = GameState.TAKING_CARDS;
    private GameData data;
    private ActionVisitor actionVisitor = new ActionPerformer(this);


    public List<CardCell> getCardCells() {
        return cardCells;
    }

    public GameData getData() {
        return data;
    }

    public Game(GameData gameData, List<User> users) {



        data = gameData;

        initData(users);

        ;
        // gameTimer.update();

    }


    //
    private RoleType getRoleTypeForPlayer() {
        return RoleType.CIVILIAN; //fixme random
    }
    //

    private void start() {
        distributeCards();
        defineDefendingPlayer();
        gameTimer.start();


    }

    private void initData(List<User> users) {

        //setting card cells
        for (int cellIndex = 0; cellIndex < data.getCellsNumber(); cellIndex++) {
            CardCell cardCell = new CardCell();
            cardCells.add(cardCell);
        }

        //converting users to players
        for (User user : users) {
            Player player = new Player(data.getInitialHealth(), getRoleTypeForPlayer(), user.getConnection(), this);
            players.add(player);
        }

        //reorder
        //Collections.shuffle(players);


    }


    private void distributeCards() {
        for (Player player : players) {
            player.setDeck(cardService.getDeckForUser(player.getId(), data));
        }

        //cardService.getDeckForUser(player.id);
    }


    private void defineDefendingPlayer() {
        defendingPlayerIndex = defendingPlayerIndex + 1;

        notifyAllDefendingPlayerSet();


    }

    private void notifyAllDefendingPlayerSet() {
        for (Player player : players) {
            player.defendingPlayerSet(players.get(defendingPlayerIndex));
        }
    }

    public void gameStateUpdated(GameState gameState, long timeMS) {
        switch (gameState) {
            case TAKING_CARDS:


                for (Player player : players) {
                    TakeCardsAction takeCardsAction = new TakeCardsAction(player);
                    takeCardsAction.accept(actionVisitor);







//                    if(player.getActiveCards().size() < data.getInitialCardNumber()){
//                        int cardsNeeds = data.getInitialCardNumber() - player.getActiveCards().size();
//                        List<GameCard> newActiveCards = player.getDeck().getCards().subList(player.getDeck().getCards().size() - cardsNeeds, player.getDeck().getCards().size());
//                        if(player.getDeck().getCards().removeAll(newActiveCards)){
//                            player.getActiveCards().addAll(newActiveCards);
//
//
//
//                            Action action = new TakeCardsAction(player.getActiveCards(),newActiveCards);
//                            player.perform(action);
//
//                        }else{
//                            //todo throw error
//                        }
//
//                    }
                }





                break;
            case THROWING:
                break;
            case BEATING:
                break;
            case DISCARD:
                break;

            default:
                break;
        }
    }


    public void putCard(Player player, GameCard gameCard, CardCell cardCell) {

    }



    private void checkPutPossibility() {

    }

    private void checkAlive() {

    }

    private void setSpectator() {

    }

    private void pickUpCards() {

    }




    //private void on

//    private void onDiscard(){
//
//    }


}

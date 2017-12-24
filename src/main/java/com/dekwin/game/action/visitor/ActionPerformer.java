package com.dekwin.game.action.visitor;

import com.dekwin.game.Game;
import com.dekwin.game.GameCard;
import com.dekwin.game.action.InitPlayerAction;
import com.dekwin.game.action.InitPlayersAction;
import com.dekwin.game.action.TakeCardsAction;

import java.util.List;

public class ActionPerformer implements ActionVisitor {
    private Game game;


    public ActionPerformer(Game game) {
        this.game = game;
    }

    @Override
    public void visit(TakeCardsAction takeCardsAction) {


        if (takeCardsAction.getPlayer().getActiveCards().size() < game.getData().getInitialCardNumber()) {
            int cardsNeeds = game.getData().getInitialCardNumber() - takeCardsAction.getPlayer().getActiveCards().size();
            List<GameCard> newActiveCards = takeCardsAction.getPlayer().getDeck().getCards().subList(takeCardsAction.getPlayer().getDeck().getCards().size() - cardsNeeds,
                    takeCardsAction.getPlayer().getDeck().getCards().size());

            if (takeCardsAction.getPlayer().getDeck().getCards().removeAll(newActiveCards)) {
                takeCardsAction.getPlayer().getActiveCards().addAll(newActiveCards);


               // Action action = new TakeCardsAction(takeCardsAction.getPlayer().getActiveCards(), newActiveCards);
                takeCardsAction.getPlayer().perform(takeCardsAction);

            } else {
                //todo throw error
            }

        }
    }

    @Override
    public void visit(InitPlayersAction initPlayersAction) {

    }

    @Override
    public void visit(InitPlayerAction initPlayerAction) {

    }


}

package com.dekwin.game.action.visitor;

import com.dekwin.game.action.InitPlayerAction;
import com.dekwin.game.action.InitPlayersAction;
import com.dekwin.game.action.TakeCardsAction;

public interface ActionVisitor {
    void visit(TakeCardsAction takeCardsAction);
    void visit(InitPlayersAction initPlayersAction);

    void visit(InitPlayerAction initPlayerAction);
}

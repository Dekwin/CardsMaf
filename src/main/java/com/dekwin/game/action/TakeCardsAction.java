package com.dekwin.game.action;

import com.dekwin.connection.netty.Packet;
import com.dekwin.game.GameCard;
import com.dekwin.game.action.visitor.ActionVisitor;
import com.dekwin.game.player.Player;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * Created by igor on 22.08.17.
 */
public class TakeCardsAction extends Packet implements Action {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public TakeCardsAction(List<GameCard> currentActiveCards, List<GameCard> newActiveCards){

    }

    public TakeCardsAction(Player player) {
        this.player = player;
    }


    public void accept(ActionVisitor actionVisitor) {
        actionVisitor.visit(this);
    }


    public void get(ByteBuf buffer) {

    }

    public void send(ByteBuf buffer) {

    }
}

package com.dekwin.game.action;

import com.dekwin.connection.netty.Packet;
import com.dekwin.game.action.visitor.ActionVisitor;
import com.dekwin.game.player.Player;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class InitPlayersAction extends Packet implements Action {

    long id;

    private List<Player> players = new ArrayList<Player>();

    public InitPlayersAction(long id, List<Player> players) {
        this.id = id;
        this.players = players;
    }

    @Override
    public void accept(ActionVisitor actionVisitor) {
        actionVisitor.visit(this);
    }

    public void get(ByteBuf buffer) {

    }

    public void send(ByteBuf buffer) {

    }

//    @Override
//    public String toString() {
//        return "{id, players general info}";
//    }


}

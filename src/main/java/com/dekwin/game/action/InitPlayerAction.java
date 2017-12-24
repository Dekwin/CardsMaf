package com.dekwin.game.action;

import com.dekwin.connection.netty.Packet;
import com.dekwin.game.action.visitor.ActionVisitor;
import io.netty.buffer.ByteBuf;

public class InitPlayerAction extends Packet implements Action {



    @Override
    public void accept(ActionVisitor actionVisitor) {
        actionVisitor.visit(this);
    }


    public void get(ByteBuf buffer) {

    }

    public void send(ByteBuf buffer) {

    }
}

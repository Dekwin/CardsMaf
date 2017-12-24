package com.dekwin.connection;



import com.dekwin.nettytest.DiscardServerHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 11.08.17.
 */
public class UserConnection extends DiscardServerHandler implements Connection {
    private List<ListeningConnection> listeningConnections = new ArrayList<>();
   // private DiscardServerHandler discardServerHandler;
    private Channel channel;



    public UserConnection(ChannelGroup channels) {

        //super(channels);
        //this.discardServerHandler = discardServerHandler;
        //this.channel = channel;

    }

    @Override
    public void send(Object object) {

        channel.write(object);
    }



    @Override
    public void receive(Object object) {
        for (ListeningConnection connection : listeningConnections){
            connection.receive(object);
        }
    }

    @Override
    public void addListeningConnection(ListeningConnection listeningConnection) {
        //fixme addListeningConnection not more than 1 for each type
        listeningConnections.add(listeningConnection);
    }

    @Override
    public void removeListeningConnection(ListeningConnection listeningConnection) {
        listeningConnections.remove(listeningConnection);
    }






    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
        if (ctx.channel().isOpen()){
            receive(msg);
        }
        ((ByteBuf) msg).release(); // (3)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       channels.add(ctx.channel());


        this.channel = ctx.channel();
        //userConnection = new UserConnection(this,ctx.channel());
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);

    }
}

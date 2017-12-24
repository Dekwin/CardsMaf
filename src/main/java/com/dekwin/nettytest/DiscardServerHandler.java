package com.dekwin.nettytest;

import com.dekwin.connection.UserConnection;
import io.netty.buffer.ByteBuf;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Handles a server-side channel.
 */
public abstract class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    protected ChannelGroup channels;
    //UserConnection userConnection;

//    public DiscardServerHandler(ChannelGroup channels) {
//        this.channels = channels;
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
//        // Discard the received data silently.
//        if (ctx.channel().isOpen()){
//            userConnection.receive(msg);
//        }
//        ((ByteBuf) msg).release(); // (3)
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
//        // Close the connection when an exception is raised.
//        cause.printStackTrace();
//        ctx.close();
//    }
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        channels.add(ctx.channel());
//
//
//        //userConnection = new UserConnection(this,ctx.channel());
//    }
//
//
//    @Override
//    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//        super.channelRegistered(ctx);
//
//    }
}
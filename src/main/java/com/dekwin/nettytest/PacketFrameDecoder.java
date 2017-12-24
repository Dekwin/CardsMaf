package com.dekwin.nettytest;

import com.dekwin.connection.netty.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class PacketFrameDecoder extends ReplayingDecoder {


//    @Override
//    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
//        ctx.sendUpstream(e);
//    }
//    @Override
//    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
//        ctx.sendUpstream(e);
//    }
//    @Override
//    protected Object decode(ChannelHandlerContext arg0, Channel arg1, ChannelBuffer buffer, VoidEnum e) throws Exception {
//        return Packet.read(buffer);
//    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(Packet.read(byteBuf));
    }
}
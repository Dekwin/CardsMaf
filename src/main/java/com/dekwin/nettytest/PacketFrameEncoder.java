package com.dekwin.nettytest;

import com.dekwin.connection.netty.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class PacketFrameEncoder extends MessageToMessageEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {



//
//        if(!(o instanceof Packet))
//            return obj; // Если это не пакет, то просто пропускаем его дальше
//        Packet p = (Packet) obj;

        if(o instanceof Packet) {
            Packet p = (Packet) o;
            ByteBuf buffer = Unpooled.buffer();
            Packet.write(p, buffer);
            list.add(buffer);
        }else {
            list.add(o);
        }

        //B // Создаём динамический буфер для записи в него данных из пакета. Если Вы точно знаете длину пакета, Вам не обязательно использовать динамический буфер — ChannelBuffers предоставляет и буферы фиксированной длинны, они могут быть эффективнее.


        //return buffer; // Возвращаем буфер, который и будет записан в канал
    }


//    @Override
//    protected Object encode(ChannelHandlerContext channelhandlercontext, Channel channel, Object obj) throws Exception {
//        if(!(obj instanceof Packet))
//            return obj; // Если это не пакет, то просто пропускаем его дальше
//        Packet p = (Packet) obj;
//
//        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer(); // Создаём динамический буфер для записи в него данных из пакета. Если Вы точно знаете длину пакета, Вам не обязательно использовать динамический буфер — ChannelBuffers предоставляет и буферы фиксированной длинны, они могут быть эффективнее.
//        Packet.write(p, buffer); // Пишем пакет в буфер
//        return buffer; // Возвращаем буфер, который и будет записан в канал
//    }
}
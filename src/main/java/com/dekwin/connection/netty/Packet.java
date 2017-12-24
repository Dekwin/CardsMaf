package com.dekwin.connection.netty;

import com.dekwin.game.action.InitPlayerAction;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public abstract class Packet {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private static Packet getPacket(int id){
        switch (id){
            case 1:
                return  new InitPlayerAction();
                //break;

                default:
                    return  new InitPlayerAction();
                   // break;
        }



    }

    public static Packet read(ByteBuf buffer) throws IOException {
        int id = buffer.readUnsignedShort(); // Получаем ID пришедшего пакета, чтобы определить, каким классом его читать
        Packet packet = getPacket(id); // Получаем инстанс пакета с этим ID
        if(packet == null)
            throw new IOException("Bad packet ID: " + id); // Если произошла ошибка и такого пакета не может быть, генерируем исключение
        packet.get(buffer); // Читаем в пакет данные из буфера
        return packet;
    }

    public static void write(Packet packet, ByteBuf buffer) {
        buffer.writeChar(packet.getId()); // Отправляем ID пакета
        packet.send(buffer); // Отправляем данные пакета
    }

    // Функции, которые должен реализовать каждый класс пакета
    public abstract void get(ByteBuf buffer);
    public abstract void send(ByteBuf buffer);
}
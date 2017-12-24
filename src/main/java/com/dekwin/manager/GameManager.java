package com.dekwin.manager;

import com.dekwin.connection.ListeningConnection;
import com.dekwin.connection.auth.AuthConnection;
import com.dekwin.connection.Connection;
import com.dekwin.game.Game;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 11.08.17.
 */
public class GameManager {
    private List<Game> games = new ArrayList<>();

    private List<ListeningConnection> connections = new ArrayList<>();

    public GameManager(ChannelGroup channels) {

        //connection = new GameManagerConnection(channels);
    }

    public void addConnection(Connection connection){

        connections.add(new AuthConnection(connection));



        //connections.add(connection);
        //connection.addListeningConnection(new AuthConnection(connection));
    }
}

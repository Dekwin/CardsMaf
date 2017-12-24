package com.dekwin.connection;

import com.dekwin.game.Deck;
import com.dekwin.game.player.Player;

/**
 * Created by igor on 12.08.17.
 */
public class GameConnection implements ListeningConnection {

    Connection userConnection;
    Player player;

    public GameConnection(Connection userConnection,Player player){
        this.userConnection = userConnection;
        this.userConnection.addListeningConnection(this);
        this.player = player;


    }

    public void leaveGame(){
        //userConnection.send("leave game id 25467");
    }


    @Override
    public void receive(Object object) {

    }

    //to client


    public void deckSet(Deck deck){

    }

}

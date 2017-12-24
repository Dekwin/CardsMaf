package com.dekwin.connection;

/**
 * Created by igor on 13.08.17.
 */
public interface ListeningConnection {
    void receive(Object object);
    //void addListeningConnection(ListeningConnection sendingConnection);
}

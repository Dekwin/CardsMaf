package com.dekwin.connection;

/**
 * Created by igor on 11.08.17.
 */
public interface Connection extends ListeningConnection, SendingConnection{

    void addListeningConnection(ListeningConnection listeningConnection);
    void removeListeningConnection(ListeningConnection listeningConnection);
}

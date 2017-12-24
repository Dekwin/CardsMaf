package com.dekwin.connection.auth;

import com.dekwin.User;
import com.dekwin.connection.Connection;
import com.dekwin.connection.ListeningConnection;
import com.dekwin.service.AuthService;

public class AuthConnection implements ListeningConnection {

    private Connection connection;
    private AuthService authService;

    public AuthConnection(Connection connection) {
        this.connection = connection;
        this.connection.addListeningConnection(this);
    }

    private User register(UserCredentialsEntity userCredentialsEntity){
        User user = authService.register(userCredentialsEntity);
        connection.send(user);
        connection.removeListeningConnection(this);
        return user;
    }

    @Override
    public void receive(Object object) {

    }
}

package com.dekwin;

import com.dekwin.connection.Connection;

/**
 * Created by igor on 13.08.17.
 */
public class User extends AbstractUser {
    public Connection getConnection() {
        return connection;
    }
}

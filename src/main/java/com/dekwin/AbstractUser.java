package com.dekwin;

import com.dekwin.connection.Connection;
import com.dekwin.connection.UserConnection;

/**
 * Created by igor on 11.08.17.
 */
public abstract class AbstractUser {
    protected Connection connection = new UserConnection();


}

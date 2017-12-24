package com.dekwin.service;

import com.dekwin.User;
import com.dekwin.connection.auth.UserCredentialsEntity;

public interface AuthService {
    User register(UserCredentialsEntity userCredentialsEntity);
}

package com.harshet.authentication.authentication.interfaces;

import com.harshet.authentication.authentication.dto.UserDTO;

public interface AuthService {
    void register(UserDTO userDTO);
    String login(UserDTO userDTO);
    void logout(String token);
}

package com.mycompany.projectmanagement.service;

import com.mycompany.projectmanagement.dto.UserDTO;

public interface UserService {

    public UserDTO register(UserDTO userDTO);
    public UserDTO login(String email , String password);
}

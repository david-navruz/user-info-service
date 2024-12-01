package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public UserDTO addUser(UserDTO userDto);

    public ResponseEntity<UserDTO> getUserById(Integer id);

}

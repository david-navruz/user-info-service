package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO addUser(UserDTO userDto) {
        User userSaved = userRepository.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(userSaved);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer id) {
        Optional<User> userFound = userRepository.findById(id);
        if (userFound.isPresent()){
            UserDTO dto = UserMapper.INSTANCE.mapUserToUserDto(userFound.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return null;
    }
}

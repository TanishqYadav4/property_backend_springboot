package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.converter.UserConverter;
import com.mycompany.projectmanagement.dto.UserDTO;
import com.mycompany.projectmanagement.entity.UserEntity;
import com.mycompany.projectmanagement.repository.UserRepository;
import com.mycompany.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> userEntity = userRepository.findByOwnerNameAndOwnerPassword(email,password);
        UserDTO userDTO = null;
        if(userEntity.isPresent()){
            userDTO = userConverter.convertEntityToDTO(userEntity.get());
            userDTO.setOwnerPassword(null);
        }
        return userDTO;
    }
}

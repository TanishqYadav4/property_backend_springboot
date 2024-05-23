package com.mycompany.projectmanagement.converter;

import com.mycompany.projectmanagement.dto.UserDTO;
import com.mycompany.projectmanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerPhone(userDTO.getOwnerPhone());
        userEntity.setOwnerPassword(userDTO.getOwnerPassword());
        return userEntity;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerPhone(userEntity.getOwnerPhone());
        userDTO.setOwnerPassword(userEntity.getOwnerPassword());
        return userDTO;
    }
}

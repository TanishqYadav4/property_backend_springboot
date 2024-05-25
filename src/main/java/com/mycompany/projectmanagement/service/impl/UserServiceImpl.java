package com.mycompany.projectmanagement.service.impl;
import com.mycompany.projectmanagement.converter.UserConverter;
import com.mycompany.projectmanagement.dto.UserDTO;
import com.mycompany.projectmanagement.entity.UserEntity;
import com.mycompany.projectmanagement.exception.BusinessException;
import com.mycompany.projectmanagement.exception.ErrorModel;
import com.mycompany.projectmanagement.repository.UserRepository;
import com.mycompany.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> entity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(entity.isPresent()){
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ALREADY_EXISTS");
            errorModel.setMessage("User with the email already exists");
            errors.add(errorModel);
            throw new BusinessException(errors);
        }
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
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Invalid Username Or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}

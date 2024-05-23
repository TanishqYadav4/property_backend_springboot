package com.mycompany.projectmanagement.controller;
import com.mycompany.projectmanagement.dto.UserDTO;
import com.mycompany.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        ResponseEntity<UserDTO> result = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return result;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getOwnerPassword());
        ResponseEntity<UserDTO> result = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return result;
    }
}

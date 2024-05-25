package com.mycompany.projectmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    @NotEmpty(message = "Username cannot be empty!")
    @NotNull(message = "Username cannot be null!")
    private String ownerName;
    @NotEmpty(message = "Email cannot be empty!")
    @NotNull(message = "Email cannot be null!")
    private String ownerEmail;
    @NotEmpty(message = "Phone number cannot be empty!")
    @NotNull(message = "Phone number cannot be null!")
    private String ownerPhone;
    @NotEmpty(message = "Password cannot be empty!")
    @NotNull(message = "Password cannot be null!")
    @Size(min = 7 , message = "Password must contain minimum seven characters!")
    private String ownerPassword;
}

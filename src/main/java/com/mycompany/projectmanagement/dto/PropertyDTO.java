package com.mycompany.projectmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long Id;
    private String title; //title of the property
    private String description; //description of the property
    private String address; // address of the property
    private Double price; //price of the property

    // now in order to access these fields outside the class
    // we need to use Getters and Setters methods.
    // These Getters and Setters can be created explicitly , or we could use Lombok's annotation
}

package com.mycompany.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "OWNER_NAME" , nullable = false)
    private String ownerName;
    @Column(name = "OWNER_EMAIL" , nullable = false)
    private String ownerEmail;
    @Column(name = "OWNER_PHONE" , nullable = false)
    private String ownerPhone;
    @Column(name = "OWNER_PASSWORD" , nullable = false)
    private String ownerPassword;
}

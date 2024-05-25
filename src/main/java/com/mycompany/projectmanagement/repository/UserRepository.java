package com.mycompany.projectmanagement.repository;

import com.mycompany.projectmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    @Query(value = "SELECT * FROM USER_TABLE WHERE OWNER_EMAIL = ?1 AND OWNER_PASSWORD = ?2" , nativeQuery = true)
    public Optional<UserEntity> findByOwnerNameAndOwnerPassword(String email, String password);

    @Query(value = "SELECT * FROM USER_TABLE WHERE OWNER_EMAIL=?1" , nativeQuery = true )
    public Optional<UserEntity> findByOwnerEmail(String email);
}

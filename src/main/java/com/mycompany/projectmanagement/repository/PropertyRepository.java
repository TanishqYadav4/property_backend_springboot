package com.mycompany.projectmanagement.repository;

import com.mycompany.projectmanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

    // this crud repository in spring data jpa contains all the basic methods
    // required to perform the crud operations, and we don't even need to provide the
    // functionality in any other class. We just need to provide the information about the Entity class , and the
    // data type of the primary key , as we have done here with PropertyEntity and Long respectively

    //object of this class is going to get injected into the service layer
}



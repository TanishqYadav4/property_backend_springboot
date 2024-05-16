package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.converter.PropertyConverter;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.entity.PropertyEntity;
import com.mycompany.projectmanagement.repository.PropertyRepository;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // this is here for helping us to tell the string that we want a singleton bean
        // to be created for this class
        // Apart from @Service annotation , @Repository, @Controller , @Configuraion , @Component can also be used
        // but we used @Service because this is meant to be a service layer
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyRepository.save(pe); // the object of the repository layer will obviously save the
                                    // object of the propertyEntity
        propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        return propertyDTO;
    }
}

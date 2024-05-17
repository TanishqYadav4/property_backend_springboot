package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.converter.PropertyConverter;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.entity.PropertyEntity;
import com.mycompany.projectmanagement.repository.PropertyRepository;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> result = new ArrayList<>();
        for( PropertyEntity pe: entities){
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            result.add(dto);
        }
        return result;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO , Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setDescription(propertyDTO.getDescription());
            pe.setTitle(propertyDTO.getTitle());
            propertyRepository.save(pe);
            propertyDTO.setId(propertyID);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public PropertyDTO updateTitle(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public PropertyDTO updateOwnerName(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setOwnerName(propertyDTO.getOwnerName());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public PropertyDTO updateOwnerEmail(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public PropertyDTO updateAddress(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setAddress(propertyDTO.getAddress());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()){
            PropertyEntity pe = propertyEntity.get();
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            return propertyDTO;
        }
        return null;
    }
}

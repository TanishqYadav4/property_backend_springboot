package com.mycompany.projectmanagement.service;
import com.mycompany.projectmanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty( PropertyDTO propertyDTO );
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty(PropertyDTO propertyDTO , Long propertyId);
    public void deleteProperty(Long propertyId);

    public PropertyDTO updateTitle(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updateOwnerName(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updateOwnerEmail(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updateAddress(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyId);
}

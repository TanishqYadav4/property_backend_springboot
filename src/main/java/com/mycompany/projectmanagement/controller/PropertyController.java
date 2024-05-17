package com.mycompany.projectmanagement.controller;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this is the annotation for providing this JAVA class
                // capabilities so that it can be used as a controller to provide API endpoints
@RequestMapping("/api/v1") // creating more elaborate and specific
                                        // URLS , mainly for versioning
                                        // for class level mapping
public class PropertyController {

    @Autowired
    private PropertyService propertyService ;

    @GetMapping("/hello")   // specifying that this method
                            // fulfills the GET request
                            // for function level mapping
    public String sayHello(){
        return "Hello World! This is the result of a GET request.";
    }

    // now we'll work on making an endpoint which will help us
    // save our property on the database , using PostMapping

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> result = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> allProperties = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<>(allProperties,HttpStatus.OK);
        return response;
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty( @RequestBody PropertyDTO propertyDTO ,
                                @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Long propertyID ){
        propertyService.deleteProperty(propertyID);
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return response;
    }

    @PatchMapping("/properties/update-title/{id}")
    public ResponseEntity<PropertyDTO> updateTitle( @RequestBody PropertyDTO propertyDTO ,
                                                       @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateTitle(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDTO> updateDescription( @RequestBody PropertyDTO propertyDTO ,
                                                    @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateDescription(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/properties/update-owner-name/{id}")
    public ResponseEntity<PropertyDTO> updateOwnerName( @RequestBody PropertyDTO propertyDTO ,
                                                          @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateOwnerName(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/properties/update-owner-email/{id}")
    public ResponseEntity<PropertyDTO> updateOwnerEmail( @RequestBody PropertyDTO propertyDTO ,
                                                        @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateOwnerEmail(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/properties/update-owner-address/{id}")
    public ResponseEntity<PropertyDTO> updateAddress( @RequestBody PropertyDTO propertyDTO ,
                                                         @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updateAddress(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }

    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePrice( @RequestBody PropertyDTO propertyDTO ,
                                                      @PathVariable("id") Long propertyID ){
        propertyDTO = propertyService.updatePrice(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return response;
    }
}

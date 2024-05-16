package com.mycompany.projectmanagement.controller;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

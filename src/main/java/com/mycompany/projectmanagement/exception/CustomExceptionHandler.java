package com.mycompany.projectmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // this annotation is crucial , as it tells spring that
                    // this is the class that we wish to act as a center for exception handling
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class) //here we specified to the spring that this is the place
                                                // where the business exceptions are being handled
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
        System.out.println("BusinessException has occured.");
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldLevelExceptions( MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<ErrorModel> errors = new ArrayList<>();
        for(FieldError fe : fieldErrors){
            ErrorModel err = new ErrorModel();
            err.setCode(fe.getCode());
            err.setMessage(fe.getDefaultMessage());
            errors.add(err);
        }
        return new ResponseEntity<List<ErrorModel>>(errors, HttpStatus.BAD_REQUEST);
    }
}

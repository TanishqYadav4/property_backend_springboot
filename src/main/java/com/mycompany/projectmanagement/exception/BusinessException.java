package com.mycompany.projectmanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException { // extending the Exception class is absolutely necessary ,
                                                    // because only then java will consider this normal class to be a
                                                    // custom exception class
    private List<ErrorModel> errors;
    public BusinessException( List<ErrorModel> errors ){
        this.errors = errors;
    }
}

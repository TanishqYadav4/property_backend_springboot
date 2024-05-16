package com.mycompany.projectmanagement.controller;

import com.mycompany.projectmanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String add( @RequestParam(name="num1",required = true) Double num1,   //RequestParam is for extracting information
                                                                                 // in the query string after the actual URL
                       @RequestParam(name="num2",required = true) Double num2){
        Double result = (num1+num2);
        String res = "The Addition of the two parameters is " + result;
        return res;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public String sub(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>=num2) result = num1 - num2;
        else result =  num2-num1;
        return "The Subtraction of the two parameters is " + result ;
    }

    @PostMapping("/mul")
    public ResponseEntity<String> mul(@RequestBody CalculatorDTO obj){
        Double result = obj.getNum1() * obj.getNum2()
                        * obj.getNum3() * obj.getNum4();
        String res = "The Multiplication of the four parameters is " + result ;
        ResponseEntity<String> objec = new ResponseEntity<String>(res , HttpStatus.CREATED);
        return objec;
    }

}

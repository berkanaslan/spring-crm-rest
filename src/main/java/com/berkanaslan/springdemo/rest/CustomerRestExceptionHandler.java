package com.berkanaslan.springdemo.rest;

import com.mysql.fabric.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author Berkan Aslan
 * 4.04.2021
 */

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}

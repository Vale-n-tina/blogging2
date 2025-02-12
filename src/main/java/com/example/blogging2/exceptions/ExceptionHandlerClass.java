package com.example.blogging2.exceptions;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(value= EntityNotFoundException.class)
    protected ResponseEntity<Error> EntityNotFound(EntityNotFoundException ex) {
        Error error=new Error();
        error.setMessage("Entity not found");
        error.setDetails(error.getMessage());
        error.setStatus(404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= EntityExistsException.class)
    protected ResponseEntity<Error> EntityExists(EntityExistsException ex) {
        Error error=new Error();
        error.setMessage("Entity already exists");
        error.setDetails(error.getMessage());
        error.setStatus(409);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }



}

package com.parkirin.controller.support.error;



import com.parkirin.exception.EntityExcistException;
import com.parkirin.exception.NotFoundException;
import com.parkirin.exception.RestTemplateException;
import com.parkirin.model.response.ErrorResponse;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(RestTemplateException.class)
    ResponseEntity<ErrorResponse> restTemplateException(RestTemplateException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X78", exception.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(NotFoundException exception){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
            ErrorResponse("X01", exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new
                ErrorResponse("X06", exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgument(MethodArgumentNotValidException exception){
        List< FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError error : fieldErrors
             ) {
            errors.add(error.getDefaultMessage());
            }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                (new ErrorResponse("X02", errors.toString()));
    }

    @ExceptionHandler(EntityActionVetoException.class)
    public ResponseEntity<ErrorResponse> handleEntityException(EntityExcistException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("X03", exception.getMessage()));
    }
}

package com.asarfi.User.exception;


import com.asarfi.User.exception.exceptionClassList.CustomMessage;
import com.asarfi.User.exception.exceptionClassList.DateConversionException;
import com.asarfi.User.exception.exceptionClassList.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<CustomMessage> handleDateParsingException(DateConversionException exception){
        CustomMessage customMessage =new CustomMessage();
        customMessage.setStatus(400);
        customMessage.setMessage("Date parsing error.Should be in format of YYYY-MM-DD");
        customMessage.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(customMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CustomMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        CustomMessage customMessage =new CustomMessage();
        customMessage.setStatus(400);
        customMessage.setMessage( String.join(", ",errorMap.values()));
        customMessage.setTimeStamp(System.currentTimeMillis());
        return  new ResponseEntity<>(customMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CustomMessage> handleResourceNotFoundException(ResourceNotFoundException exception){
        CustomMessage customMessage =new CustomMessage();
        customMessage.setStatus(404);
        customMessage.setMessage(exception.getMessage());
        customMessage.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(customMessage, HttpStatus.NOT_FOUND);
    }
}

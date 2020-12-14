package com.spring.addressbook.exceptions;

import com.spring.addressbook.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
                                        MethodArgumentNotValidException exception){
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        List<String> errorMsg = errors.stream().map(Error -> Error.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Rest Request Exception : ", errorMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeNotFoundException(ContactNotFoundException exception){
        ResponseDTO responseDTO = new ResponseDTO("Rest Request Exception", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}

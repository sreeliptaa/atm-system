package com.bridgelabz.atmsystem.exception;

import com.bridgelabz.atmsystem.dto.ResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose: To handle all the exceptions globally
 *
 * @author SREELIPTA
 * @since : 04-12-2021
 */
@ControllerAdvice
public class AtmSystemGlobalException extends ResponseEntityExceptionHandler {

    /**
     * Purpose : Returns a response for MethodArgumentNotValidException.
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> objectMap = new LinkedHashMap<>();
        objectMap.put("timestamp", new Date());
        objectMap.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        objectMap.put("errors", errors);
        return new ResponseEntity<>(objectMap, headers, status);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleCustomException(ResourceNotFoundException resourceNotFoundException) {
        ResponseDto responseDto = new ResponseDto
                (HttpStatus.NOT_FOUND, resourceNotFoundException.getLocalizedMessage());
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());
    }
}

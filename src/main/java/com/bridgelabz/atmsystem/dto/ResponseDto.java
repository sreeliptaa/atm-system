package com.bridgelabz.atmsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Purpose : To define the http error details
 *
 * @author SREELIPTA
 * @since 04-12-2021
 */
@Data
@AllArgsConstructor
public class ResponseDto {
    private final HttpStatus httpStatus;
    private String message;
}

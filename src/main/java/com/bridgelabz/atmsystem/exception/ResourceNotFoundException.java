package com.bridgelabz.atmsystem.exception;

/**
 * Purpose: To define resource not found message
 *
 * @author SREELIPTA
 * @since : 04-12-2021
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

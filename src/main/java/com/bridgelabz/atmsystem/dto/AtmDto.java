package com.bridgelabz.atmsystem.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * Purpose : To contain data from client and validate them
 *
 * @author SREELIPTA
 * @since 04-12-2021
 */
@Data
public class AtmDto {

    @Pattern(regexp = "^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$",
            message = "Card Number Should be only 16 Digit")
    private String cardNumber;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$",
            message = "Not a Valid Name!!The name can not contain any numbers or symbols")
    private String cardName;

    @Pattern(regexp = "^[0-9]{3}", message = "Cvv Should be only 3 Digit")
    private String cvv;
}

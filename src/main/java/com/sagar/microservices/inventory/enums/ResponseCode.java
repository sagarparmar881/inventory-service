package com.sagar.microservices.inventory.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    IN_STOCK("Product is in stock", HttpStatus.CREATED),
    NOT_IN_STOCK("Product is not in stock", HttpStatus.OK);

    private final String message;
    private final HttpStatus httpStatus;
}
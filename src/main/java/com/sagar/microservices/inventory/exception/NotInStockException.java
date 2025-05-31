package com.sagar.microservices.inventory.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotInStockException extends InventoryServiceException {

    /**
     * Exception thrown when a product is not found with the given identifier.
     *
     * @param skuCode the skuCode of the product that was not found
     * @param quantity the quantity of the product that was not found
     */
    public NotInStockException(final String skuCode, final int quantity) {
        super("Item with SKU code '" + skuCode + "' and quantity " + quantity + " is not in stock."
        );
    }

    public NotInStockException() {
        super("Item with SKU code is not in stock.!");
    }
}
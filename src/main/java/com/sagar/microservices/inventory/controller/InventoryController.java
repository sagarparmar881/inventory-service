package com.sagar.microservices.inventory.controller;

import com.sagar.microservices.inventory.dto.InventoryDto;
import com.sagar.microservices.inventory.enums.ResponseCode;
import com.sagar.microservices.inventory.response.ApiResponse;
import com.sagar.microservices.inventory.response.InventoryServiceResponse;
import com.sagar.microservices.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    /**
     * Service layer dependency responsible for inventory processing logic.
     */
    private final InventoryService inventoryService;

    /**
     * Handles HTTP GET requests to check if a item is in stock
     * Checks in to the inventoryService and
     * returns a success message upon completion.
     *
     * @param skuCode skuCode to be checked
     * @param quantity quantity to be checked
     * @return a confirmation if a item is in stock or not
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> checkInStock(
            @RequestParam final String skuCode,
            @RequestParam final int quantity
    ) {

        var isInStock = inventoryService.isInStock(skuCode, quantity);
        return InventoryServiceResponse.build(
                isInStock ? ResponseCode.IN_STOCK : ResponseCode.NOT_IN_STOCK,
                skuCode
        );
    }
}

package com.sagar.microservices.inventory.service;

import com.sagar.microservices.inventory.model.Inventory;
import com.sagar.microservices.inventory.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public Boolean isInStock(final String skuCode, final int quantity) {

        Inventory inventory = this.findBySkuCodeAndQuantityGreaterThanEqual(
                skuCode, quantity);
        return Objects.nonNull(inventory);
    }

    public Inventory findBySkuCodeAndQuantityGreaterThanEqual(
            final String skuCode, final int quantity) {

        Optional<Inventory> inventoryEntity = this.inventoryRepository.
                findBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
        return inventoryEntity.orElse(null);
    }
}

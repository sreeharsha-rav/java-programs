package org.ecommerce.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ecommerce.inventoryservice.model.Inventory;
import org.ecommerce.inventoryservice.repository.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }

    public boolean doesSkuCodeExist(String skuCode) {
        return inventoryRepository.existsBySkuCode(skuCode);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

}

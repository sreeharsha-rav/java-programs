package org.ecommerce.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.inventoryservice.model.Inventory;
import org.ecommerce.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/exists")
    @ResponseStatus(HttpStatus.OK)
    public boolean doesSkuCodeExist(@RequestParam String skuCode) {
        return inventoryService.doesSkuCodeExist(skuCode);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }

}

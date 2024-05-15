package org.ecommerce.orderservice.client;

import org.ecommerce.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "api/inventory")
    List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes);

}

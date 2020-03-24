package io.joachimprinzbach.pizzainventory.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name = "pizza-inventory-service", url = "${pizza.inventory.url:http://pizza-inventory-service.pizza-inventory-${env}}/")
public interface PizzaInventoryClient {

    @Operation(summary = "get all available pizza items",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success!")
            })
    @GetMapping("/api/pizza/items")
    Set<PizzaInventoryItemDto> getPizzaInventoryItems();
}
package io.joachimprinzbach.pizzainventory.api;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name = "pizza-inventory-service", url = "${pizza.inventory.url:http://pizza-inventory-service.pizza-inventory-${env}}/")
@Api("Pizza Inventory API")
public interface PizzaInventoryClient {

    @GetMapping("/api/pizza/items")
    Set<PizzaInventoryItemDto> getPizzaInventoryItems();
}
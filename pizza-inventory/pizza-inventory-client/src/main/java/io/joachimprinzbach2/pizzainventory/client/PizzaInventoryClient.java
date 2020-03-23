package io.joachimprinzbach2.pizzainventory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name = "pizza-inventory", url = "${pizza.inventory.url:http://pizza-inventory-service.pizza-inventory-${env}}/")
public interface PizzaInventoryClient {

    @GetMapping("/api/pizza/items")
    Set<PizzaInventoryItem> getPizzaInventoryItems();
}
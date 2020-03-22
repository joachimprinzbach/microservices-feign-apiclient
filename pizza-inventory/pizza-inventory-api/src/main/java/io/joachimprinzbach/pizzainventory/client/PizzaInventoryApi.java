package io.joachimprinzbach.pizzainventory.client;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

public interface PizzaInventoryApi {

    @GetMapping("/api/pizza/items")
    Set<PizzaInventoryItem> getPizzaInventoryItems();
}

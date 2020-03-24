package io.joachimprinzbach.pizzaorder;

import io.joachimprinzbach.pizzainventory.api.PizzaInventoryClient;
import io.joachimprinzbach.pizzainventory.api.PizzaInventoryItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
class PizzaOrderRestController {

    private final PizzaInventoryClient pizzaInventoryApi;

    @GetMapping(path = "api/pizza/orders")
    public Set<PizzaInventoryItemDto> getAvailablePizzaItems() {
        Set<PizzaInventoryItemDto> inventoryItems = pizzaInventoryApi.getPizzaInventoryItems();
        log.info("Found " + inventoryItems.size() + " items in inventory.");
        return inventoryItems;
    }
}

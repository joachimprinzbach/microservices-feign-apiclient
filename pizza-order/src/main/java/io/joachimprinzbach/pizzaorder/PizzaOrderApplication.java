package io.joachimprinzbach.pizzaorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
@EnableFeignClients
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }

}

@RestController
@RequiredArgsConstructor
@Slf4j
class PizzaOrderRestController {

    private final PizzaInventoryClient pizzaInventoryClient;

    @GetMapping(path = "api/pizza/orders")
    public Set<PizzaInventoryItem> getAvailablePizzaItems() {
        Set<PizzaInventoryItem> inventoryItems = pizzaInventoryClient.getPizzaInventoryItems();
        log.info("Found " + inventoryItems.size() + " items in inventory.");
        return inventoryItems;
    }
}

@FeignClient(name = "pizza-inventroy", url = "${pizza-inventory-service.url}")
interface PizzaInventoryClient {

    @GetMapping("/api/pizza/items")
    Set<PizzaInventoryItem> getPizzaInventoryItems();
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class PizzaInventoryItem {

    private String name;
    private int quantity;
}

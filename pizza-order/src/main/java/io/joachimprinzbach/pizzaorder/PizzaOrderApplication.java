package io.joachimprinzbach.pizzaorder;

import io.joachimprinzbach.pizzainventory.client.PizzaInventoryApi;
import io.joachimprinzbach.pizzainventory.client.PizzaInventoryItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
@EnableFeignClients(basePackages = {"io.joachimprinzbach"})
@ComponentScan("io.joachimprinzbach")
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }

}

@RestController
@RequiredArgsConstructor
@Slf4j
class PizzaOrderRestController {

    private final PizzaInventoryApi pizzaInventoryApi;

    @GetMapping(path = "api/pizza/orders")
    public Set<PizzaInventoryItem> getAvailablePizzaItems() {
        Set<PizzaInventoryItem> inventoryItems = pizzaInventoryApi.getPizzaInventoryItems();
        log.info("Found " + inventoryItems.size() + " items in inventory.");
        return inventoryItems;
    }
}
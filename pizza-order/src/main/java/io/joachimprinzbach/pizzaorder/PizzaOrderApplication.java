package io.joachimprinzbach.pizzaorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }

}

@RestController
@RequiredArgsConstructor
@Slf4j
class PizzaOrderRestController {

    @Value("${pizza-inventory-service.url}")
    private String pizzaInventoryServiceUrl;

    @GetMapping(path = "api/pizza/orders")
    public Set<PizzaInventoryItem> getAvailablePizzaItems() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        PizzaInventoryItem[] inventoryItems = restTemplate.getForObject(pizzaInventoryServiceUrl, PizzaInventoryItem[].class);
        log.info("Found " + inventoryItems.length + " items in inventory.");
        return new HashSet<>(Arrays.asList(inventoryItems));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PizzaInventoryItem {

    private String name;
    private int quantity;
}

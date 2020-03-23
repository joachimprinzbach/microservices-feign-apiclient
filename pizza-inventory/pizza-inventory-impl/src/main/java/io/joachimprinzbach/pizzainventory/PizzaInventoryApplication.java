package io.joachimprinzbach.pizzainventory;

import io.joachimprinzbach.pizzainventory.api.PizzaInventoryClient;
import io.joachimprinzbach.pizzainventory.api.PizzaInventoryItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class PizzaInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaInventoryApplication.class, args);
    }

}

@RestController
class PizzaInventoryRestController implements PizzaInventoryClient {

    @Override
    public Set<PizzaInventoryItem> getPizzaInventoryItems() {
        return Stream
                .of(
                        new PizzaInventoryItem("Salami", 10),
                        new PizzaInventoryItem("Funghi", 3))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

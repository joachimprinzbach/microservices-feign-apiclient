package io.joachimprinzbach.pizzainventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
class PizzaInventoryRestController {

    @GetMapping(path = "api/pizza/items")
    public Set<PizzaInventoryItem> getAvailablePizzaItems() {
        return Stream
                .of(
                        new PizzaInventoryItem("Salami", 10),
                        new PizzaInventoryItem("Funghi", 3))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PizzaInventoryItem {

    private String name;
    private int quantity;
}

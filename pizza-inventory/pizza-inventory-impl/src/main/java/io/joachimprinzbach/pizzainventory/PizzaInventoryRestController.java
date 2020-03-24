package io.joachimprinzbach.pizzainventory;

import io.joachimprinzbach.pizzainventory.api.PizzaInventoryClient;
import io.joachimprinzbach.pizzainventory.api.PizzaInventoryItemDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
class PizzaInventoryRestController implements PizzaInventoryClient {

    @Value("${env}")
    private String env;

    @Override
    public Set<PizzaInventoryItemDto> getPizzaInventoryItems() {
        return Stream
                .of(
                        new PizzaInventoryItemDto("Salami from " + env, 10),
                        new PizzaInventoryItemDto("Funghi from " + env, 3))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

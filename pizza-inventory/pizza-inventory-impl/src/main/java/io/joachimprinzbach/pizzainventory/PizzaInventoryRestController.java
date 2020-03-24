package io.joachimprinzbach.pizzainventory;

import io.joachimprinzbach.pizzainventory.api.PizzaInventoryClient;
import io.joachimprinzbach.pizzainventory.api.PizzaInventoryItemDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
class PizzaInventoryRestController implements PizzaInventoryClient {

    @Override
    public Set<PizzaInventoryItemDto> getPizzaInventoryItems() {
        return Stream
                .of(
                        new PizzaInventoryItemDto("Salami", 10),
                        new PizzaInventoryItemDto("Funghi", 3))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

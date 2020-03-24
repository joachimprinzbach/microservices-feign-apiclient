package io.joachimprinzbach.pizzaorder;

import io.joachimprinzbach.pizzainventory.api.PizzaInventoryClient;
import io.joachimprinzbach.pizzainventory.api.PizzaInventoryItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }

}


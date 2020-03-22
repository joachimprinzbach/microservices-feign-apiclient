package io.joachimprinzbach.pizzainventory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

@Profile("!dev")
@FeignClient(name = "pizza-inventroy", url = "http://pizza-inventory-service.pizza-inventory-test:8080/")
public interface PizzaInventoryClientProd extends PizzaInventoryApi {

}
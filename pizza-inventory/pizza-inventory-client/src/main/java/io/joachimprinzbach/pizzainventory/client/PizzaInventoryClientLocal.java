package io.joachimprinzbach.pizzainventory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@FeignClient(name = "pizza-inventroy", url = "http://localhost:8080/")
public interface PizzaInventoryClientLocal extends PizzaInventoryApi {

}

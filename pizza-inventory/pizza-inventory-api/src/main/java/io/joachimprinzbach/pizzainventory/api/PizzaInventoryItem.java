package io.joachimprinzbach.pizzainventory.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaInventoryItem {

    private String name;
    private int quantity;
}

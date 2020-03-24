package io.joachimprinzbach.pizzainventory.api;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Pizza Inventory Item Dto")
public class PizzaInventoryItemDto {

    private String name;
    private int quantity;
}

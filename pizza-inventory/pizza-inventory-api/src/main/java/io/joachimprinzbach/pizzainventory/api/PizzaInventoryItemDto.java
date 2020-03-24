package io.joachimprinzbach.pizzainventory.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Pizza Inventory Model", description = "The model for pizza inventory")
public class PizzaInventoryItemDto {

    @Schema(description = "The pizza name")
    private String name;
    @Schema(description = "The quantity of this pizza in stock")
    private int quantity;
}

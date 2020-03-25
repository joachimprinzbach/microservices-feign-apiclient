# microservices-istio

Use case for a MircoService REST API with a [client](./pizza-inventory/pizza-inventory-api/src/main/java/io/joachimprinzbach/pizzainventory/api/PizzaInventoryClient.java) that can be consumed by a [consumer application](./pizza-order/src/main/java/io/joachimprinzbach/pizzaorder/PizzaOrderRestController.java).
Have a look at [the deployment configuration](https://github.com/joachimprinzbach/okd4-deployment-configuration) for the environments and different services.

## Modules

### Pizza-Order
The "WebAppliation" that provides a [Frontend](https://joachim-pizza-order-prod.apps.origin.baloise.dev/) and a Backend for the Frontend with a REST API.

The [REST-API Client](./pizza-order/src/main/java/io/joachimprinzbach/pizzaorder/PizzaOrderRestController.java)) gets its data from a microservice called `pizza-inventory`. 


### Pizza-Inventory
The MicroService provides a simple [REST-API](./pizza-inventory/pizza-inventory-impl/src/main/java/io/joachimprinzbach/pizzainventory/PizzaInventoryRestController.java).

Besides the API, a [Client Stub](./pizza-inventory/pizza-inventory-api/src/main/java/io/joachimprinzbach/pizzainventory/api/PizzaInventoryClient.java) and a [DTO](./pizza-inventory/pizza-inventory-api/src/main/java/io/joachimprinzbach/pizzainventory/api/PizzaInventoryItemDto.java) is provided as jar File that can be used by consumers.

The service environment is derived from the current env of the consumer, but can be overriden by setting a property.  

You can access the Service "UI" with a link to the OpenApi Spec [here](https://joachim-pizza-inventory-prod.apps.origin.baloise.dev/).

## Run locally
Run `mvn clean install`

Then run both, the pizza-inventory-impl and the pizza-order with the active profile `dev`.
Open http://localhost:8080/ and http://localhost:8081/ in your webbrowser.
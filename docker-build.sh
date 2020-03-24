#!/bin/sh
docker build pizza-inventory/pizza-inventory-impl -t joachimprinzbach/pizza-inventory:11
docker build pizza-order -t joachimprinzbach/pizza-order:11
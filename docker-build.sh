#!/bin/sh
docker build pizza-inventory/impl -t joachimprinzbach/pizza-inventory:9
docker build pizza-order -t joachimprinzbach/pizza-order:9
#!/bin/sh
VERSION=13
DOCKER_ORG=joachimprinzbach
mvn clean install
docker build pizza-inventory/pizza-inventory-impl -t $DOCKER_ORG/pizza-inventory:$VERSION
docker build pizza-order -t $DOCKER_ORG/pizza-order:$VERSION

docker push $DOCKER_ORG/pizza-inventory:$VERSION
docker push $DOCKER_ORG/pizza-order:$VERSION
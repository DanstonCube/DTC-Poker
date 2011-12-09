#!/bin/bash

cd common/
mvn clean install

cd ../addon/
mvn
./majdist.sh

cd ../plugin/
mvn
./majdist.sh

cd ..


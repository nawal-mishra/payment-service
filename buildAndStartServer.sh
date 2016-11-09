#!/bin/bash

ENV=$1
VERSION=$2

if [[ ${VERSION} = "" ]]; then
    VERSION="1.0.0"
fi

if [[ ${ENV} = "" ]]; then
    echo "Building the project pointing to local environment"
    ./gradlew clean build
else
    echo "Building the project pointing to ${ENV} environment"
    ./gradlew clean build -Penv=${ENV}
fi

echo "Accessing the service distributions"
cd build/distributions

echo "Unzipping the order service folder version ${VERSION}"
unzip payment-service-${VERSION}.zip
cd -

echo "Starting the service"
sudo ./build/distributions/payment-service-${VERSION}/bin/payment-service server ./build/distributions/payment-service-${VERSION}/conf/config.yml

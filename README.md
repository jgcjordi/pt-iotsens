# Technical prove to IoT Sens 🧮

This have two parts, this is the backend side.
On the folder others is the description

## How to run it

```shell
docker-compose up --build
```

## Endpoint Curl


getPriceOfProduct:
```shell
curl --location 'http://localhost:8080/price/35455?applicationDate=2020-06-20T12%3A00%3A00'
```

getAllPrices:
```shell
curl --location 'http://localhost:8080/price/all'
```

## Observations

